package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Color
import android.text.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aranandroid.customview.R
import com.blankj.utilcode.util.CloneUtils
import com.blankj.utilcode.util.SizeUtils.sp2px
import com.blankj.utilcode.util.ThreadUtils
import java.util.regex.Matcher
import java.util.regex.Pattern


class SquareTextEdit(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    val textview: TextView

    val edittext: EditText

    var textsize = sp2px(14f).toFloat()
        set(value) {
            field = value
            textview.setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize)
        }
    var editsize = sp2px(14f).toFloat()
        set(value) {
            field = value
            edittext.setTextSize(TypedValue.COMPLEX_UNIT_PX,editsize)
        }
    var textcolor = Color.BLACK
        set(value) {
            field = value
            textview.setTextColor(textcolor)
        }
    var editcolor = Color.BLACK
        set(value) {
            field = value
            edittext.setTextColor(editcolor)
        }
    var hintcolor = Color.GRAY
        set(value) {
            field = value
            edittext.setHintTextColor(hintcolor)
        }
    var hint: String? = null
        set(value) {
            field = value
            edittext.setHint(hint)

        }
    var key: String? = null
        set(value) {
            field = value
            textview.setText(key)
        }
    var valueme: String? = null
        set(value) {
            field = value
            if (TextUtils.isEmpty(valueme)) {
                edittext.setText(null)
            } else {
                edittext.setText(valueme)
            }
        }
    var gravityKey = 0
        set(value) {
            field = value
            textview.gravity = field
        }
    var gravityValue = 0
        set(value) {
            field = value
            edittext.gravity = field
        }

    var single = false
        set(value) {
            field = value
            edittext.isSingleLine = field
        }

    var typeValue = InputType.TYPE_CLASS_TEXT
        set(value) {
            field = value
            edittext.inputType = field
        }

    var maxLengthValue = 30
        set(value) {
            field = value
            edittext.filters = arrayOf(NameLengthFilter(field))
        }

    private class NameLengthFilter(private val max:Int) : InputFilter {

        private fun getChineseCount(str: String): Int {
            var count = 0
            val regEx = "[\\u4e00-\\u9fa5]" // unicode编码，判断是否为汉字

            val p: Pattern = Pattern.compile(regEx)
            val m: Matcher = p.matcher(str)
            while (m.find()) {
                for (i in 0..m.groupCount()) {
                    count = count + 1
                }
            }
            return count
        }

        override fun filter(
            source: CharSequence?,
            start: Int,
            end: Int,
            dest: Spanned?,
            dstart: Int,
            dend: Int
        ): CharSequence {
            val destCount: Int = dest.toString().length + getChineseCount(dest.toString())
            val sourceCount: Int = source.toString().length + getChineseCount(source.toString())
            return if (destCount + sourceCount > max) {
                // Toast.makeText(MainActivity.this, getString(R.string.count),
                // Toast.LENGTH_SHORT).show();
                ""
            } else {
                source!!
            }
        }
    }


    val view: View


    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextEdit)
        view = LayoutInflater.from(context).inflate(R.layout.square_text_edit, this, true)
        textview = view.findViewById(R.id.text)
        edittext = view.findViewById(R.id.edit)

        textsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextEdit_text_size,
            sp2px(14f).toFloat()
        )
        editsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextEdit_edit_size,
            sp2px(14f).toFloat()
        )

        textcolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextEdit_text_color,
            Color.BLACK
        )

        editcolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextEdit_edit_color,
            Color.BLACK
        )

        hintcolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextEdit_hint_color,
            Color.GRAY
        )

        hint = obtainStyledAttributes.getString(
            R.styleable.SquareTextEdit_hint
        )

        key = obtainStyledAttributes.getString(
            R.styleable.SquareTextEdit_key
        )

        valueme = obtainStyledAttributes.getString(
            R.styleable.SquareTextEdit_value
        )

        gravityKey = obtainStyledAttributes.getInt(R.styleable.SquareTextEdit_gravity_key,Gravity.CENTER)
        gravityValue = obtainStyledAttributes.getInt(R.styleable.SquareTextEdit_gravity_value,Gravity.CENTER_VERTICAL or Gravity.RIGHT)
        single = obtainStyledAttributes.getBoolean(R.styleable.SquareTextEdit_single,true)
        typeValue = obtainStyledAttributes.getInt(R.styleable.SquareTextEdit_type_value,InputType.TYPE_CLASS_TEXT)
        maxLengthValue = obtainStyledAttributes.getInt(R.styleable.SquareTextEdit_max_length_value,30)


    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }





    @InverseBindingAdapter(attribute = "value", event = "valueAttrChanged")
    fun getValue(squ:SquareTextEdit): String? {
        return squ.edittext.text?.toString()
    }


    @BindingAdapter("value", requireAll = false)
    fun setValue(squ:SquareTextEdit,text: MutableLiveData<String>?) {
        ThreadUtils.runOnUiThread(Runnable { squ.valueme = text?.value })

        text?.let {
            if (!it.hasObservers()) {
                it.observe(this.context as LifecycleOwner, Observer { level ->
                    ThreadUtils.runOnUiThread(Runnable {
                        val selectionStart = squ.edittext.getSelectionStart()
                        squ.valueme = level
                        squ.edittext.setSelection(selectionStart)
                    })
                })
            }
        }

    }

    @BindingAdapter("valueAttrChanged", requireAll = false)
    fun valueAttrChanged(squ:SquareTextEdit,inverseBindingListener: InverseBindingListener?) {
        squ.edittext.addTextChangedListener(object : TextWatcher {
            var temp :String? = null
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                if (TextUtils.isEmpty(s)) {
                    temp = ""
                }else temp = CloneUtils.deepClone(s.toString(), String::class.java)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!temp!!.equals(s.toString())) {
                    inverseBindingListener?.onChange()
                }
                if (TextUtils.isEmpty(s)) {
                    temp = ""
                }else temp = CloneUtils.deepClone(s.toString(), String::class.java)
            }
        })

    }



}





