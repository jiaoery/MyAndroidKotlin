package com.example.myandroidkotlin.customview.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice03SetTextSizeView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    :View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var y = 100

        // 使用 paint.setTextSize() 来设置不同大小的文字

        // 第一处：文字大小 16
        paint.textSize = 16f
        canvas.drawText(text, 50f, y.toFloat(), paint)
        y += 30
        // 第一处：文字大小 24
        paint.textSize = 24f
        canvas.drawText(text, 50f, y.toFloat(), paint)
        y += 55
        // 第一处：文字大小 48
        paint.textSize = 48f
        canvas.drawText(text, 50f, y.toFloat(), paint)
        y += 80
        // 第一处：文字大小 72
        paint.textSize = 72f
        canvas.drawText(text, 50f, y.toFloat(), paint)
    }
}