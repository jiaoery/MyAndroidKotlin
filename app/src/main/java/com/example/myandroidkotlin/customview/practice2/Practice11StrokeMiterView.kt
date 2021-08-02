package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class Practice11StrokeMiterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(100f, 100f)
        // MITER 值：1
        paint.strokeMiter = 1f
        canvas.drawPath(path, paint)
        canvas.translate(300f, 0f)
        // MITER 值：2
        paint.strokeMiter = 2f
        canvas.drawPath(path, paint)
        canvas.translate(300f, 0f)
        // MITER 值：5
        paint.strokeMiter = 5f
        canvas.drawPath(path, paint)
        canvas.restore()
    }

    init {
        paint.strokeWidth = 40f
        paint.style = Paint.Style.STROKE
        path.rLineTo(200f, 0f)
        path.rLineTo(-160f, 120f)
    }
}