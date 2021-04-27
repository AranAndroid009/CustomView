package com.aranandroid.customview.fragment

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * 描述：
 * -
 * 创建人：ybr
 * 创建时间：2021
 */
class NoScrollViewPager : ViewPager {
    val DISABLE = false

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!,
        attrs
    ) {
    }

    override fun onInterceptTouchEvent(arg0: MotionEvent): Boolean {
        return DISABLE && super.onInterceptTouchEvent(arg0)
    }

    override fun onTouchEvent(arg0: MotionEvent): Boolean {
        return DISABLE && super.onTouchEvent(arg0)
    }
}