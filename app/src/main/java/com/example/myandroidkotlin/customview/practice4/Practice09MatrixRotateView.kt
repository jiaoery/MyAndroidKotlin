package com.example.myandroidkotlin.customview.practice4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice09MatrixRotateView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point1 = Point(200, 200)
    var point2 = Point(600, 200)
    var mMatrix  = Matrix()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.save()
        mMatrix.reset()
        mMatrix.setRotate(
            180f,
            (point1.x + bitmap!!.width / 2).toFloat(),
            (point1.y + bitmap!!.height / 2).toFloat()
        )
        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap!!, point1.x.toFloat(), point1.y.toFloat(), paint)
        canvas.restore()
        canvas.save()
        mMatrix.reset()
        mMatrix.setRotate(
            90f,
            (point2.x + bitmap!!.width / 2).toFloat(),
            (point2.y + bitmap!!.height / 2).toFloat()
        )
        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap!!, point2.x.toFloat(), point2.y.toFloat(), paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
    }
}