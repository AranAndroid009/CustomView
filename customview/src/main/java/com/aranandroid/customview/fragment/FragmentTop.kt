package com.aranandroid.customview.fragment

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.aranandroid.customview.R

class FragmentTop(context: Context?, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    var view:View

    var radio:RadioGroup

    var viewPager: ViewPager

    var fragments: LinkedHashMap<Int,Fragment>? = null
        set(value) {
            field = value
            radio.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
                fragments?.keys?.let {
                    var i = 0
                    for (key in it) {
                        if(checkedId == key){
                            viewPager.setCurrentItem(i,true)
                        }
                        i++
                    }
                }
            })
            val fm: FragmentManager = (context as FragmentActivity).getSupportFragmentManager()
            val myFragmentPagerAdapter =
                fragments?.values?.toList()?.let { MyFragmentPagerAdapter(fm, it) } //new myFragmentPagerAdater记得带上两个参数
            viewPager.adapter = myFragmentPagerAdapter
            viewPager.offscreenPageLimit = 3
            viewPager.addOnPageChangeListener(object : OnPageChangeListener{
                override fun onPageScrollStateChanged(state: Int) {
                    TODO("Not yet implemented")
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionoffsetpixels: Int
                ) {
                    TODO("Not yet implemented")
                }

                override fun onPageSelected(position: Int) {
                    TODO("Not yet implemented")
                    fragments?.keys?.let {
                        var i = 0
                        for (key in it) {
                            if(position == i){
                                radio.check(key)
                            }
                            i++
                        }
                    }
                }
            })
        }

    init {
        view = LayoutInflater.from(context).inflate(R.layout.fragment_top, this, true)
        radio = view.findViewById(R.id.radio)
        viewPager = view.findViewById(R.id.pager)
    }

    constructor(context: Context?):this(context,null){

    }

    override fun dispatchDraw(canvas: Canvas?) {

        super.dispatchDraw(canvas)
//        addChildrenForAccessibility()
        val children = children
        for (child in children) {
            if(child.id != R.id.fragment_top){
                (child.parent as ViewGroup).removeView(child)
                radio.addView(child)
            }
        }
    }


    class MyFragmentPagerAdapter(
        fm: FragmentManager?,
        list: List<Fragment>
    ) :
        FragmentPagerAdapter(fm!!,FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val listfragment //创建一个List<Fragment>
                : List<Fragment>

        override fun getItem(arg0: Int): Fragment {
            return listfragment[arg0] //返回第几个fragment
        }

        override fun getCount(): Int {
            return listfragment.size //总共有多少个fragment
        }

        // 定义构造带两个参数
        init {
            listfragment = list
        }
    }

}