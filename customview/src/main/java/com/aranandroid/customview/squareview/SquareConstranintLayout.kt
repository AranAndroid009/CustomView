package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout

class SquareConstranintLayout(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,
        0
    )

    constructor(context: Context?) : this(context, null) {

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }



}