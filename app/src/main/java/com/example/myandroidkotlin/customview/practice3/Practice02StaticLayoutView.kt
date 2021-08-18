package com.example.myandroidkotlin.customview.practice3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class Practice02StaticLayoutView@JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    :View(context, attrs, defStyleAttr) {
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello\nHenCoder"

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
//        canvas.drawText(text, 50, 100, textPaint);
        canvas.save()
        canvas.translate(50f, 100f)
        val staticLayout =
            StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
        staticLayout.draw(canvas)
        canvas.restore()
    }

    init {
        textPaint.textSize = 60f
    }
}