package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatButton

class SquareButton(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    AppCompatButton(context!!, attrs, defStyleAttr) {

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

}