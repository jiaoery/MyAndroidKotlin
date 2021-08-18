package com.example.myandroidkotlin.customview.sample3

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

class Sample04SetTypefaceView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var text = "Hello HenCoder"
    var typeface: Typeface? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.typeface = null
        canvas.drawText(text, 50f, 100f, paint)
        paint.typeface = Typeface.SERIF
        canvas.drawText(text, 50f, 200f, paint)
        paint.typeface = typeface
        canvas.drawText(text, 50f, 300f, paint)
    }

    init {
        paint.textSize = 60f
        typeface = Typeface.createFromAsset(context.assets, "Satisfy-Regular.ttf")
    }
}