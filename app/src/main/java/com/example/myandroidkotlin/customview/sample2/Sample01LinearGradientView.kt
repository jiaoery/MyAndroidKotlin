package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Sample01LinearGradientView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?=null,
    defStyleAttr: Int=0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(300f, 300f, 200f, paint)
    }

    init {
        paint.shader = LinearGradient(
            100f, 100f, 500f, 500f, Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"), Shader.TileMode.CLAMP
        )
    }
}