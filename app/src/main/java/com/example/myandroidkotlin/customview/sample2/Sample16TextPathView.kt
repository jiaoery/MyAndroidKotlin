package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Sample16TextPathView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var pathPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var textPath = Path()
    var text = "Hello HenCoder"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text, 50f, 200f, paint)
        canvas.drawPath(textPath, pathPaint)
    }

    init {
        paint.textSize = 120f
        paint.getTextPath(text, 0, text.length, 50f, 400f, textPath)
        pathPaint.style = Paint.Style.STROKE
    }
}