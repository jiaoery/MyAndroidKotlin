package com.example.myandroidkotlin.customview.practice1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice4DrawPointView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.strokeWidth = 60f
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawPoint((width / 4).toFloat(), (height / 2).toFloat(), paint)
        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawPoint((width * 3 / 4).toFloat(), (height / 2).toFloat(), paint)
        //        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
    }
}