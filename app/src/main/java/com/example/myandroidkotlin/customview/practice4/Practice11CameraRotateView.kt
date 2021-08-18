package com.example.myandroidkotlin.customview.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice11CameraRotateView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 200)
    var point2 = Point(600, 200)
    var camera = Camera()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        camera.save()
        camera.rotateX(30f)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.drawBitmap(bitmap!!, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()
        canvas.save()
        camera.save()
        camera.rotateY(30f)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.drawBitmap(bitmap!!, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }
}