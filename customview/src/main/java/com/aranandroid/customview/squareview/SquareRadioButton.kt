package com.aranandroid.customview.squareview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.view.children
import com.aranandroid.customview.R

class SquareRadioButton(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    AppCompatRadioButton(context!!, attrs, defStyleAttr) {

    var squareView: SquareView
    var squareSelectedView: SquareSelectedView

    var fristCheck = false

    var oldTextColors: Int = Color.BLACK

    var selectTextColor = Color.BLACK

        init {
        squareSelectedView = SquareSelectedView(context, attrs, defStyleAttr, this)
        squareView = SquareView(context, attrs, defStyleAttr, this)
        setOnClickListener(null)
        fristCheck = isChecked
            val obtainStyledAttributes =
                context?.obtainStyledAttributes(attrs, R.styleable.SquareRadioButton)
            obtainStyledAttributes.let {
                selectTextColor = it?.getColor(
                    R.styleable.SquareRadioButton_selected_text_color,
                    Color.BLACK
                )!!
            }
        }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        android.R.attr.textViewStyle

    )

    constructor(context: Context?) : this(context, null) {

    }


    override fun setOnClickListener(l: OnClickListener?) {
        val onClickListener = OnClickListener { v ->
            refreshState()
            l?.onClick(v)
        }
        super.setOnClickListener(onClickListener)
    }


    private fun refreshState() {
        var parenttemp: ViewParent? = parent
        while (parenttemp !is RadioGroup) {
            if (parenttemp == null) {
                break
            }
            parenttemp = parenttemp?.parent
        }
        if (parenttemp is RadioGroup) {
            parenttemp.check(id)
        }
        refreshView(parenttemp as View, parenttemp as View)
    }

    private fun refreshView(parentme: View?,parenttemp: View?) {
        if (parenttemp == null) {
            return
        }
        if ((parenttemp as ViewGroup).childCount>0 &&   (parenttemp).getChildAt(0) is SquareRadioButton) {
            val radioGroup = parenttemp as ViewGroup
            for (i in 0 until radioGroup.getChildCount()) {
                val childAt = radioGroup.getChildAt(i)
                if (childAt is SquareRadioButton) {
                    if ((parentme as RadioGroup)?.checkedRadioButtonId == childAt.id) {
                        background = squareSelectedView.getBackGround()
                        setTextColor(selectTextColor)
                    } else {
                        childAt.background = squareView.getBackGround()
                        childAt.setOldTextColor()
                    }
                }
            }
        }else{
            for (child in (parenttemp as ViewGroup).children) {
                refreshView(parentme,child)
            }
        }



    }

    private fun setOldTextColor() {
        setTextColor(oldTextColors)
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        if (fristCheck){
            fristCheck = false
            oldTextColors = this.currentTextColor
            refreshState()
        }
    }


}