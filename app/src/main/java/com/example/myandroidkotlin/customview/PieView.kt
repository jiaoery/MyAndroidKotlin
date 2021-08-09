package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.utils.dp
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 150f.dp
private val ANGELS = floatArrayOf(60f, 90f, 150f, 60f)
private val COLORS = listOf(
    Color.parseColor("#C2185B"),
    Color.parseColor("#00ACC1"),
    Color.parseColor("#558B2F"),
    Color.parseColor("#5D4037")
)
private var OFFSET = 20f

class PieView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var startAngel = 0f
        for ((index, angel) in ANGELS.withIndex()) {
            if(index==2){
                canvas.save()
                canvas.translate((OFFSET* cos(Math.toRadians((startAngel+angel/2).toDouble()))).toFloat(),(OFFSET* sin(Math.toRadians((startAngel+angel/2).toDouble()))).toFloat())
            }
            paint.color = COLORS[index]
            canvas.drawArc(
                width / 2 - RADIUS,
                height / 2 - RADIUS,
                width / 2 + RADIUS,
                height / 2 + RADIUS,
                startAngel,
                ANGELS[index],
                true,
                paint
            )
            startAngel += ANGELS[index]
            if (index == 2){
                canvas.restore()
            }

        }
    }
}