package com.example.myandroidkotlin.customview.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice05RotateView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 200)
    var point2 = Point(600, 200)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //转180 度
        canvas.save()
        canvas.rotate(
            180f,
            (point1.x + bitmap!!.width / 2).toFloat(),
            (point1.y + bitmap!!.height / 2).toFloat()
        )
        canvas.drawBitmap(bitmap!!, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()

        //转45度
        canvas.save()
        canvas.rotate(
            45f,
            (point2.x + bitmap!!.width / 2).toFloat(),
            (point2.y + bitmap!!.height / 2).toFloat()
        )
        canvas.drawBitmap(bitmap!!, point2.x.toFloat(), point2.y.toFloat(), paint)
        canvas.restore()
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }
}