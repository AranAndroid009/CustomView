package com.aranandroid.customview.utils

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.annotation.ColorInt
import com.blankj.utilcode.util.SizeUtils.dp2px


class DrawableBuilder {
    private var shape = GradientDrawable.RECTANGLE
    private var lineWidth = 0

    @ColorInt
    private var lineColor = Color.TRANSPARENT
    private lateinit var cornerRadius:FloatArray

    /**
     * 背景颜色，默认透明
     */
    @ColorInt
    private var bkColor = Color.TRANSPARENT

    /**
     * 虚线边框每个单元的长度
     */
    private var dashWidth = 0f

    /**
     * 虚线边框每个单元之间的间距
     */
    private var dashGap = 0f
    fun build(): Drawable {
        val bg = GradientDrawable()
        bg.shape = shape
        bg.setStroke(lineWidth, lineColor, dashWidth, dashGap)
        bg.cornerRadii = cornerRadius
        bg.setColor(bkColor)
        return bg
    }

    fun shape(shape: Int): DrawableBuilder {
        this.shape = shape
        return this
    }
    /**
     * 构造线框
     * @param width
     * @param color
     * @return
     */
    /**
     * 默认生成一个 1 dp 939393 的园线
     * @return
     */
    @JvmOverloads
    fun line(
        width: Float = defaultLineWidth,
        color: Int = defaultLineColor
    ): DrawableBuilder {
        return lineWidth(width).lineColor(color)
    }

    fun line(width: Float, color: String): DrawableBuilder {
        return lineWidth(width).lineColor(color)
    }

    /**
     * 设置边框线条粗细 直接传入具体数值
     *
     * @return
     */
    fun lineWidth(lineWidth: Float): DrawableBuilder {
        this.lineWidth = dp2px(lineWidth)
        return this
    }

    fun lineColor(lineColor: Int): DrawableBuilder {
        this.lineColor = lineColor
        return this
    }

    fun lineColor(lineColor: String): DrawableBuilder {
        require(lineColor[0] == '#') { "color value must be start with # like #000000" }
        return lineColor(Color.parseColor(lineColor))
    }
    /**
     * 设置圆角度数，直接传入具体数值
     * @param cornerRadius
     * @return
     */
    /**
     * 配置默认的圆角度数 为2
     * @return
     */
    @JvmOverloads
    fun corner(cornerRadius: FloatArray = defaultCornerRadius): DrawableBuilder {
        this.cornerRadius = cornerRadius
        return this
    }

    /**
     * 大圆角
     * @return
     */
    fun roundCorner(): DrawableBuilder {
        return corner()
    }

    fun fill(@ColorInt bkColor: Int): DrawableBuilder {
        this.bkColor = bkColor
        return this
    }

    fun fill(bkColor: String): DrawableBuilder {
        require(bkColor[0] == '#') { "color value must be start with # like #000000" }
        return fill(Color.parseColor(bkColor))
    }

    /**
     * 生成一个默认的虚线 shape
     * @return
     */
    fun dash(): DrawableBuilder {
        return dashWidth(defaultDashWidth.toFloat()).dashGap(
            defaultDashGap.toFloat()
        )
    }

    fun dashWidth(dashWidth: Float): DrawableBuilder {
        this.dashWidth = dp2px(dashWidth).toFloat()
        return this
    }

    fun dashGap(dashGap: Float): DrawableBuilder {
        this.dashGap = dp2px(dashGap).toFloat()
        return this
    }

    companion object {
        //默认线条粗细 1dp
        private const val defaultLineWidth = 1F
        private val defaultLineColor = Color.parseColor("#e9e9e9")
        private val defaultCornerRadius = floatArrayOf(
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat(),
            dp2px(2F).toFloat())

        //椭圆形圆角
        private const val defaultRoundCornerRadius = 100

        //默认虚线条单位长度 6dp
        private const val defaultDashWidth = 6

        //默认虚线条之间的间距 2dp
        private const val defaultDashGap = 2
    }
}