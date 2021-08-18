package com.example.myandroidkotlin.customview.sample3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class Sample02StaticLayoutView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello\nHenCoder"
    var staticLayout: StaticLayout? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        canvas.translate(50f, 40f)
        staticLayout!!.draw(canvas)
        canvas.restore()
    }

    init {
        textPaint.textSize = 60f
        // 这两行的位置不能换哟
        staticLayout = StaticLayout(text, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true)
    }
}