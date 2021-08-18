package com.example.myandroidkotlin.customview.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class Practice13GetTextBoundsView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    :View(context, attrs, defStyleAttr)  {
    var paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
    var text1 = "A"
    var text2 = "a"
    var text3 = "J"
    var text4 = "j"
    var text5 = "Â"
    var text6 = "â"
    var top = 200f
    var bottom = 400f
    var textRect = Rect()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(50f, top, (width - 50).toFloat(), bottom, paint1)

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差
        val middle = (top + bottom) / 2
        paint2.getTextBounds(text1, 0, text1.length, textRect)
        val middle1 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text1, 100f, middle1, paint2)
        paint2.getTextBounds(text2, 0, text2.length, textRect)
        val middle2 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text2, 200f, middle2, paint2)
        paint2.getTextBounds(text3, 0, text3.length, textRect)
        val middle3 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text3, 300f, middle3, paint2)
        paint2.getTextBounds(text4, 0, text4.length, textRect)
        val middle4 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text4, 400f, middle4, paint2)
        paint2.getTextBounds(text5, 0, text5.length, textRect)
        val middle5 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text5, 500f, middle5, paint2)
        paint2.getTextBounds(text6, 0, text6.length, textRect)
        val middle6 = middle - (textRect.bottom + textRect.top) / 2
        canvas.drawText(text6, 600f, middle6, paint2)
    }

    init {
        paint1.style = Paint.Style.STROKE
        paint1.strokeWidth = 20f
        paint1.color = Color.parseColor("#E91E63")
        paint2.textSize = 160f
    }
}