package com.aranandroid.customview.squareview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import com.aranandroid.customview.R
import com.blankj.utilcode.util.SizeUtils.sp2px

class SquareTextEdit(
    @Nullable context: Context?,
    @Nullable attrs: AttributeSet?,
    defStyleAttr: Int
) :
    ConstraintLayout(context!!, attrs, defStyleAttr) {

    var squareView: SquareView

    var textsize = sp2px(14f).toFloat()
    set(value) {field = value
    invalidate()}

    var editsize = sp2px(14f).toFloat()
        set(value) {field = value
            invalidate()}

    var textcolor = Color.BLACK
    set(value) {field = value
    invalidate()}

    init {
        squareView = SquareView(context, attrs, defStyleAttr, this)
        val obtainStyledAttributes =
            context!!.obtainStyledAttributes(attrs, R.styleable.SquareTextEdit)
        LayoutInflater.from(context).inflate(R.layout.square_text_edit,this,true)

        textsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextEdit_text_size,
            sp2px(14F).toFloat()
        )
        editsize = obtainStyledAttributes.getDimension(
            R.styleable.SquareTextEdit_edit_size,
            sp2px(14F).toFloat()
        )

        obtainStyledAttributes.getColor(
            R.styleable.SquareTextEdit_text_color,
            Color.BLACK
        )

        obtainStyledAttributes.getColor(
            R.styleable.SquareTextEdit_edit_size,
            Color.BLACK
        )


        <!--        左边文字颜色-->
        <attr name="text_color" format="color"/>
        <!--        右边编辑框文字颜色-->
        <attr name="edit_color" format="color"/>
        <!--        提示文字颜色-->
        <attr name="hint_color" format="color"/>
        <!--        提示文字-->
        <attr name="hint" format="string"/>
        <!--        左边文字-->
        <attr name="key" format="string"/>
        <!--        右边文字-->
        <attr name="value" format="string"/>
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





