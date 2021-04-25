package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.blankj.utilcode.util.ConvertUtils

class SquareTextText(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    val keyView:TextView

    val valueView:TextView

    var keysize = 14f
        set(value) {
            field = value
            keyView.setTextSize(keysize)
        }
    var valuesize = 14f
        set(value) {
            field = value
            valueView.setTextSize(valuesize)
        }
    var keycolor = Color.BLACK
        set(value) {
            field = value
            keyView.setTextColor(keycolor)
        }
    var valuecolor = Color.BLACK
        set(value) {
            field = value
            valueView.setTextColor(valuecolor)
        }

    var key : String? = null
        set(value) {
            field = value
            keyView.setText(key)
        }
    var valueme : String? = null
        set(value) {
            field = value
            if(TextUtils.isEmpty(valueme)){
                valueView.setText(null)
            }else{
                valueView.setText(valueme)
            }
        }
    var gravityKey = 0
        set(value) {
            field = value
            valueView.gravity = field
        }
    var gravityValue = 0
        set(value) {
            field = value
            valueView.gravity = field
        }

    var single = false
        set(value) {
            field = value
            valueView.isSingleLine = field
        }
    val view: View


    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextText)
        view = LayoutInflater.from(context).inflate(R.layout.square_text_text, this, true)
        keyView = view.findViewById(R.id.text)
        valueView = view.findViewById(R.id.textright)

        keysize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextText_key_size,
            (14F).toFloat()
        )
        valuesize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextText_value_size,
            (14F).toFloat()
        )

        keycolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextText_key_color,
            Color.BLACK
        )

        valuecolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextText_value_color,
            Color.BLACK
        )

        key = obtainStyledAttributes.getString(
            R.styleable.SquareTextText_key
        )

        valueme = obtainStyledAttributes.getString(
            R.styleable.SquareTextText_value
        )

        gravityKey = obtainStyledAttributes.getInt(R.styleable.SquareTextText_gravity_key, Gravity.CENTER)
        gravityValue = obtainStyledAttributes.getInt(R.styleable.SquareTextText_gravity_value,
            Gravity.CENTER_VERTICAL or Gravity.RIGHT)
        single = obtainStyledAttributes.getBoolean(R.styleable.SquareTextText_single,true)



    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }




}





