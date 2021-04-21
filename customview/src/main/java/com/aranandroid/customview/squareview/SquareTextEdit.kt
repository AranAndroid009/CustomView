package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R

class SquareTextEdit(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
        LayoutInflater.from(context).inflate(R.layout.square_text_edit,this,true)
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





