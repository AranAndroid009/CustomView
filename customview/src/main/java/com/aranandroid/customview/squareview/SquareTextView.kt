package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.Shape
import android.util.AttributeSet
import android.util.TypedValue
import androidx.annotation.Nullable
import com.aranandroid.customview.R
import com.aranandroid.customview.utils.DrawableBuilder

class SquareTextView(@Nullable context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    androidx.appcompat.widget.AppCompatTextView(context!!, attrs, defStyleAttr) {

    init {
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextView)
        obtainStyledAttributes.getBoolean()

    }
    constructor(context: Context?, attrs: AttributeSet?): this(context, attrs,android.R.attr.textViewStyle){

    }

    constructor(context: Context?): this(context, null){

    }



    override fun onDraw(canvas: Canvas?) {
//        lineWidth(int width)	设置线条宽度，参数为具体数值，无需转换
//        lineColor(int lineColor)	设置线条颜色
//        corner(1 2 3 4)	设置圆角度数
//        dashWidth(float dashWidth)	设置虚线每个单元长度
//        dashGap(float dashGap)	设置虚线边框每个单元之间的间距
//        fill(@ColorInt int bkColor)


        val drawableBuilder = DrawableBuilder()


        background = drawableBuilder.build()
        super.onDraw(canvas)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec)
    }


}