package com.example.myandroidkotlin.customview.sample3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Sample10SetTextAlignView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr)  {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText(text, (width / 2).toFloat(), 100f, paint)
        paint.textAlign = Paint.Align.CENTER
        canvas.drawText(text, (width / 2).toFloat(), 200f, paint)
        paint.textAlign = Paint.Align.RIGHT
        canvas.drawText(text, (width / 2).toFloat(), 300f, paint)
    }

    init {
        paint.textSize = 60f
    }
}