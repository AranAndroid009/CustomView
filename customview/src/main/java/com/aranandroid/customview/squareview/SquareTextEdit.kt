package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.blankj.utilcode.util.ConvertUtils

class SquareTextEdit(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    val textview: TextView

    val edittext: EditText

    var textsize = 14f
        set(value) {
            field = value
            textview.setTextSize(textsize)
        }
    var editsize = 14f
        set(value) {
            field = value
            edittext.setTextSize(editsize)
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
            (14F).toFloat()
        )
        editsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextEdit_edit_size,
            (14F).toFloat()
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


    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }


}





