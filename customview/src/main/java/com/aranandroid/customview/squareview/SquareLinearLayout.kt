package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.annotation.Nullable

class SquareLinearLayout(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    LinearLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        android.R.attr.textViewStyle
    )

    constructor(context: Context?) : this(context, null) {

    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = squareView.getBackGround()
    }


}