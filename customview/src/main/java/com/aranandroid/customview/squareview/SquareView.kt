package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import com.aranandroid.customview.R
import com.aranandroid.customview.utils.DrawableBuilder

open class SquareView(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int,
    private val view: View
) {
    val DEFZERO = 0F
    private var corner: Float = 0F

    var cornerlt: Float
    var cornerlb: Float
    var cornerrt: Float
    var cornerrb: Float

    var dashwidth: Float = 0F
    var dashgap: Float = 0F
    var linecolor: Int = 0
    var fillcolor: Int = 0
    var linewidth: Float = 0F

    fun setCorner(value:Float) {
        corner = value
        cornerlt = 0F
        cornerlb = 0F
        cornerrt = 0F
        cornerrb = 0F

    }

    fun refreshBackground() {
        view.background = getBackGround()
    }

    init {
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextView)
        //圆角
        corner =
            obtainStyledAttributes.getDimension(R.styleable.SquareTextView_corner, DEFZERO)
        cornerlt =
            obtainStyledAttributes.getDimension(R.styleable.SquareTextView_corner_left_top, DEFZERO)
        cornerlb = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextView_corner_left_bottom,
            DEFZERO
        )
        cornerrt = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextView_corner_right_top,
            DEFZERO
        )
        cornerrb = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextView_corner_right_bottom,
            DEFZERO
        )
        //线宽
        linewidth =
            obtainStyledAttributes.getDimension(R.styleable.SquareTextView_line_width, DEFZERO)
        //虚线宽度
        dashwidth =
            obtainStyledAttributes.getDimension(R.styleable.SquareTextView_dash_width, DEFZERO)
        // 虚线间距
        dashgap = obtainStyledAttributes.getDimension(R.styleable.SquareTextView_dash_gap, 2F)
        // 线颜色
        linecolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextView_line_color,
            Color.TRANSPARENT
        )
        // 填充颜色
        fillcolor = obtainStyledAttributes.getColor(
            R.styleable.SquareTextView_background_color,
            Color.TRANSPARENT
        )
        view.background = getBackGround()
    }


    fun getBackGround(): Drawable {
        var drawableBuilder = DrawableBuilder().corner()
        if (DEFZERO != corner) {
            drawableBuilder = drawableBuilder.corner(
                floatArrayOf(
                    corner, corner, corner, corner,
                    corner, corner, corner, corner
                )
            )
        }

        if (DEFZERO != cornerlt || DEFZERO != cornerlb || DEFZERO != cornerrt || DEFZERO != cornerrb) {
            drawableBuilder =
                drawableBuilder.corner(
                    floatArrayOf(
                        cornerlt, cornerlt, cornerrt, cornerrt,
                         cornerrb, cornerrb,cornerlb, cornerlb
                    )
                )
        }

        if (DEFZERO != linewidth) {
            drawableBuilder = drawableBuilder.line().lineWidth(linewidth).lineColor(linecolor)
        }

        if (DEFZERO != dashwidth) {
            drawableBuilder = drawableBuilder.dash().dashWidth(dashwidth).dashGap(dashgap)
        }

        if (fillcolor != 0) {
            drawableBuilder = drawableBuilder.fill(fillcolor)
        }
        return drawableBuilder.build()
    }


    /**
     * 左上 左下 右上 右下
     */
    fun setCorners(float: FloatArray) {
        cornerlt = float[0]
        cornerlb = float[1]
        cornerrt = float[2]
        cornerrb = float[3]
        view.background = getBackGround()
    }


}