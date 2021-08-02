package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Sample08XfermodeView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap1: Bitmap? = null
    var bitmap2: Bitmap? = null
    var xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
    var xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
    var xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(bitmap1!!, 0f, 0f, paint)
        paint.xfermode = xfermode1
        canvas.drawBitmap(bitmap2!!, 0f, 0f, paint)
        paint.xfermode = null
        canvas.drawBitmap(bitmap1!!, (bitmap1!!.width + 100).toFloat(), 0f, paint)
        paint.xfermode = xfermode2
        canvas.drawBitmap(bitmap2!!, (bitmap1!!.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null
        canvas.drawBitmap(bitmap1!!, 0f, (bitmap1!!.height + 20).toFloat(), paint)
        paint.xfermode = xfermode3
        canvas.drawBitmap(bitmap2!!, 0f, (bitmap1!!.height + 20).toFloat(), paint)
        paint.xfermode = null
        canvas.restoreToCount(saved)
    }

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }
}