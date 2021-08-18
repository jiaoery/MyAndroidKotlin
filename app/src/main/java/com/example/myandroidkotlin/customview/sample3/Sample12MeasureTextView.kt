package com.example.myandroidkotlin.customview.sample3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Sample12MeasureTextView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr)  {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var text1 = "三个月内你胖了"
    var text2 = "4.5"
    var text3 = "公斤"
    var measuredText1 = 0f
    var measuredText2 = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text1, 50f, 200f, paint1)
        canvas.drawText(text2, 50 + measuredText1, 200f, paint2)
        canvas.drawText(text3, 50 + measuredText1 + measuredText2, 200f, paint1)
    }

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
        measuredText1 = paint1.measureText(text1)
        measuredText2 = paint2.measureText(text2)
    }
}