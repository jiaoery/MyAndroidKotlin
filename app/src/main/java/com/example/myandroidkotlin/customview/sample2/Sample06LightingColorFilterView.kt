package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Sample06LightingColorFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var colorFilter1: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)
    var colorFilter2: ColorFilter = LightingColorFilter(0xffffff, 0x003000)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.colorFilter = colorFilter1
        canvas.drawBitmap(bitmap!!, 0f, 0f, paint)
        paint.colorFilter = colorFilter2
        canvas.drawBitmap(bitmap!!, (bitmap!!.width + 100).toFloat(), 0f, paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }
}