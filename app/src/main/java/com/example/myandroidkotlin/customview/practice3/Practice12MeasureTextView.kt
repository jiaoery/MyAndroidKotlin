package com.example.myandroidkotlin.customview.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice12MeasureTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    :View(context, attrs, defStyleAttr) {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var text1 = "三个月内你胖了"
    var text2 = "4.5"
    var text3 = "公斤"



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.measureText 测量出文字宽度，让文字可以相邻绘制
        canvas.drawText(text1, 50f, 200f, paint1)
        val textWidth1 = paint1.measureText(text1)
        canvas.drawText(text2, 50 + textWidth1, 200f, paint2)
        val textWidth2 = paint2.measureText(text2)
        canvas.drawText(text3, 50 + textWidth1 + textWidth2, 200f, paint1)
    }

    init {
        paint1.textSize = 60f
        paint2.textSize = 120f
        paint2.color = Color.parseColor("#E91E63")
    }
}