package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.utils.dp
class MeasureTextView@JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet?=null,
    defStyleAttr: Int=0
) : View(context, attrs, defStyleAttr){

    val CIRCLE_COLOR = Color.parseColor("#90A4AE")
    val HIGHLIGHT_COLOR = Color.parseColor("#FF4081")
    val RING_WIDTH = 20.dp
    val RADIUS = 150.dp
    val round = Rect()

    val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 100.dp
        textAlign = Paint.Align.CENTER
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        setMeasuredDimension(w,h)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = RING_WIDTH
        paint.color = CIRCLE_COLOR
        canvas.drawCircle(width/2f,height/2f,RADIUS,paint)

        paint.strokeCap = Paint.Cap.ROUND
        paint.color = HIGHLIGHT_COLOR
        canvas.drawArc(width/2f-RADIUS,width/2f-RADIUS,width/2f+RADIUS,height/2f+RADIUS,-90f,225f,false,paint)

        paint.style = Paint.Style.FILL
        paint.getTextBounds("abab",0,"abab".length,round)
        canvas.drawText("abab",0,"abab".length,width/2f,height/2f-(round.top+round.bottom)/2f,paint)

    }

}