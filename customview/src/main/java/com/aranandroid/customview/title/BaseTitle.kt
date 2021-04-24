package com.aranandroid.customview.title

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.ViewGroup
import android.view.Window
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import com.aranandroid.customview.squareview.SquareView
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ImmersionBar

open class BaseTitle(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context!!, attrs, defStyleAttr) {
    init {
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }

    override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)
        if (context is Activity) {
            if (parent is TitleLayout) {
                ImmersionBar.with(context as Activity).titleBar(this)
                    .init()

            }
        }
    }
}