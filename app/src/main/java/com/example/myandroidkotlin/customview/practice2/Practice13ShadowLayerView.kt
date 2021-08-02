package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice13ShadowLayerView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.setShadowLayer(10f, 0f, 0f, Color.RED)
        paint.textSize = 120f
        canvas.drawText("Hello HenCoder", 50f, 200f, paint)
    }
}