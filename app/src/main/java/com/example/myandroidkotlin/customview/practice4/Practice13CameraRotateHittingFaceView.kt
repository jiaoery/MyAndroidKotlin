package com.example.myandroidkotlin.customview.practice4

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.example.myandroidkotlin.R

class Practice13CameraRotateHittingFaceView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var point = Point(200, 50)
    var camera = Camera()
    var animator = ObjectAnimator.ofInt(this, "degree", 0, 360)
    var degrees = 0
    var mMatrix = Matrix()


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        animator.end()
    }

    fun setDegree(degree: Int) {
        this.degrees = degree
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val bitmapWidth = bitmap!!.width
        val bitmapHeight = bitmap!!.height
        val centerX = point.x + bitmapWidth / 2
        val centerY = point.y + bitmapHeight / 2
        camera.save()
        mMatrix.reset()
        camera.rotateX(degrees.toFloat())
        camera.getMatrix(mMatrix)
        camera.restore()
        mMatrix.preTranslate(-centerX.toFloat(), -centerY.toFloat())
        mMatrix.postTranslate(centerX.toFloat(), centerY.toFloat())
        canvas.save()
        canvas.concat(mMatrix)
        canvas.drawBitmap(bitmap!!, point.x.toFloat(), point.y.toFloat(), paint)
        canvas.restore()
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.maps)
        if(bitmap!=null){
            val scaledBitmap =
                Bitmap.createScaledBitmap(bitmap!!, bitmap!!.getWidth() * 2, bitmap!!.getHeight() * 2, true)
            bitmap!!.recycle()
            bitmap = scaledBitmap
            animator.duration = 5000
            animator.interpolator = LinearInterpolator()
            animator.repeatCount = ValueAnimator.INFINITE
            val displayMetrics = resources.displayMetrics
            val newZ = -displayMetrics.density * 6
            camera.setLocation(0f, 0f, newZ)
        }

    }
}