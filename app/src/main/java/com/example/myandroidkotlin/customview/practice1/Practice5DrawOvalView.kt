package com.example.myandroidkotlin.customview.practice1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class Practice5DrawOvalView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var rectF = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        rectF.left = width.toFloat() / 2 - 180f
        rectF.top = height.toFloat() / 2 - 90f
        rectF.right = width.toFloat() / 2 + 180f
        rectF.bottom = height.toFloat() / 2 + 90f
        canvas.drawOval(rectF, paint)
        //        练习内容：使用 canvas.drawOval() 方法画椭圆
    }
}