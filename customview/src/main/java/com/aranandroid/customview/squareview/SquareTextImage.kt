package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.SizeUtils.sp2px

class SquareTextImage(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    val textview:TextView

    val imageView:ImageView

    var textsize = sp2px(14f).toFloat()

        set(value) {
            field = value
            textview.setTextSize(TypedValue.COMPLEX_UNIT_PX,textsize)
        }

    var textcolor = Color.BLACK
        set(value) {
            field = value
            textview.setTextColor(textcolor)
        }
    var key : String? = null
        set(value) {
            field = value
            textview.setText(key)
        }
    var valueme : Int = 0
        set(value) {
            field = value
            if(valueme<0){
                imageView.setImageDrawable(null)
            }else{
                imageView.setImageResource(valueme)
            }
        }
    val view: View


    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextImage)
        view = LayoutInflater.from(context).inflate(R.layout.square_text_image, this, true)
        textview = view.findViewById(R.id.text)
        imageView = view.findViewById(R.id.image)

        textsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextImage_key_size,
            sp2px(14F).toFloat()
        )

        textcolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextImage_key_color,
            Color.BLACK
        )


        key = obtainStyledAttributes.getString(
            R.styleable.SquareTextImage_key
        )

        valueme = obtainStyledAttributes.getResourceId(
            R.styleable.SquareTextImage_src
        ,0)



    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }




}





