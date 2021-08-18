package com.example.myandroidkotlin.customview.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice10SetTextAlignView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    :View(context, attrs, defStyleAttr){
var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setTextAlign() 来调整文字对齐方式

        // 第一处：使用 Paint.Align.LEFT
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(text, (width / 2).toFloat(), 100f, paint)

        // 第二处：使用 Paint.Align.CENTER
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, (width / 2).toFloat(), 200f, paint)

        // 第三处：使用 Paint.Align.RIGHT
        paint.textAlign = Paint.Align.RIGHT
        canvas.drawText(text, (width / 2).toFloat(), 300f, paint)
    }

    init {
        paint.textSize = 60f

        // 使用 Paint.setTextAlign() 来调整文字对齐方式
    }
}