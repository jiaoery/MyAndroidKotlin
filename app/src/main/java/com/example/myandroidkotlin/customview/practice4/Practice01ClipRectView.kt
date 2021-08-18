package com.example.myandroidkotlin.customview.practice4

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice01ClipRectView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val left = (width - bitmap!!.width) / 2
        val top = (height - bitmap!!.height) / 2
        canvas.save()
        canvas.clipRect(left + 50, top + 50, left + 300, top + 200)
        canvas.drawBitmap(bitmap!!, left.toFloat(), top.toFloat(), paint)
        canvas.restore()
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }
}