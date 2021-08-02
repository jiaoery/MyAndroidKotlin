package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice09StrokeCapView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setStrokeCap() 来设置端点形状

        // 第一个：BUTT
        paint.strokeCap = Paint.Cap.BUTT
        canvas.drawLine(50f, 50f, 400f, 50f, paint)

        // 第二个：ROUND
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(50f, 150f, 400f, 150f, paint)

        // 第三个：SQUARE
        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawLine(50f, 250f, 400f, 250f, paint)
    }

    init {
        paint.strokeWidth = 40f
    }
}