package com.aranandroid.customview.title

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.aranandroid.customview.squareview.SquareView
import com.blankj.utilcode.util.SizeUtils.sp2px

class TitleView(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    BaseTitle(context!!, attrs, defStyleAttr) {

    val view: View

    val leftView: TextView
    val rightView: TextView
    val titleView: TextView


    // 左边文字大小
    var leftSize = sp2px(11f).toFloat()
        set(value) {
            field = value
            leftView.setTextSize(TypedValue.COMPLEX_UNIT_PX,leftSize)
        }

    // 左边文字颜色
    var leftColor = Color.BLACK
        set(value) {
            field = value
            leftView.setTextColor(leftColor)
        }

    // 左边文字
    var left : String? = null
        set(value) {
            field = value
            leftView.text = left
        }

    //图片、背景实现
    var leftSrc = 0
        set(value) {
            field = value
            if (field != 0) {
                leftView.setBackgroundResource(leftSrc)
            }
        }

    // 是否返回功能
    var back = false
        set(value) {
            field = value
            if (field) {
                leftView.setText("")
                leftView.setBackgroundResource(R.mipmap.back)
                leftView.setOnClickListener { v ->
                    if (context is Activity) {
                        (context as Activity).finish()
                    }
                }
            }
        }

    // 标题文字大小
    var titleSize = sp2px(14f).toFloat()
        set(value) {
            field = value
            titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX,titleSize)
        }

    // 标题文字颜色
    var titleColor = Color.BLACK
        set(value) {
            field = value
            titleView.setTextColor(titleColor)
        }

    // 标题文字
    var title = "Title"
        set(value) {
            field = value
            titleView.text = title
        }

    // 右边文字大小
    var rightSize = sp2px(11f).toFloat()
        set(value) {
            field = value
            rightView.setTextSize(TypedValue.COMPLEX_UNIT_PX,field)
        }

    // 右边文字颜色
    var rightColor = Color.BLACK
        set(value) {
            field = value
            rightView.setTextColor(field)
        }

    // 右边文字
    var right : String? = null
        set(value) {
            field = value
            rightView.text = right
        }

    // 图片 、背景实现
    var rightSrc = 0
        set(value) {
            field = value
            if (field != 0) {
                rightView.setBackgroundResource(rightSrc)
            }
        }


    init {
        view = LayoutInflater.from(context).inflate(R.layout.view_title, this, true)
        leftView = view.findViewById(R.id.left)
        rightView = view.findViewById(R.id.right)
        titleView = view.findViewById(R.id.title)
        val obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TitleView)
        // 左边文字大小
        leftSize = obtainStyledAttributes.getDimension(R.styleable.TitleView_left_size,sp2px(11f).toFloat())
        // 左边文字颜色
        leftColor = obtainStyledAttributes.getColor(R.styleable.TitleView_left_color,Color.BLACK)
        // 左边文字
        left = obtainStyledAttributes.getString(R.styleable.TitleView_left)

        //图片、背景实现
        leftSrc = obtainStyledAttributes.getResourceId(R.styleable.TitleView_left_src,0)

        // 是否返回功能
        back = obtainStyledAttributes.getBoolean(R.styleable.TitleView_back,false)

        // 标题文字大小
        titleSize = obtainStyledAttributes.getDimension(R.styleable.TitleView_title_size,
            sp2px(14f).toFloat()
        )

        // 标题文字颜色
        titleColor = obtainStyledAttributes.getColor(R.styleable.TitleView_title_color,Color.BLACK)

        // 标题文字
        obtainStyledAttributes.getString(R.styleable.TitleView_title)?.let { title = it }

        // 右边文字大小
        rightSize = obtainStyledAttributes.getDimension(R.styleable.TitleView_right_size,sp2px(11f).toFloat())


        // 右边文字颜色
        rightColor = obtainStyledAttributes.getColor(R.styleable.TitleView_right_color,Color.BLACK)

        // 右边文字
        right = obtainStyledAttributes.getString(R.styleable.TitleView_right)

        // 图片 、背景实现
        rightSrc = obtainStyledAttributes.getResourceId(R.styleable.TitleView_right_src,0)
    }

    constructor(context: Context, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context) : this(context, null) {

    }
}