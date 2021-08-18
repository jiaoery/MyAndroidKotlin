package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice08XfermodeView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap1: Bitmap? = null
    var bitmap2: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 paint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer
        val saved1 = canvas.saveLayer(null, null)
        canvas.drawBitmap(bitmap1!!, 0f, 0f, paint)
        val xfermode1: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        paint.xfermode = xfermode1
        // 第一个：PorterDuff.Mode.SRC
        canvas.drawBitmap(bitmap2!!, 0f, 0f, paint)
        paint.xfermode = null
        canvas.restoreToCount(saved1)

        val saved2 = canvas.saveLayer(null, null)
        canvas.drawBitmap(bitmap1!!, (bitmap1!!.width + 100).toFloat(), 0f, paint)
        // 第二个：PorterDuff.Mode.DST_IN
        val xfermode2: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        paint.xfermode = xfermode2
        canvas.drawBitmap(bitmap2!!, (bitmap1!!.width + 100).toFloat(), 0f, paint)
        paint.xfermode = null
        canvas.restoreToCount(saved2)

        val saved3 = canvas.saveLayer(null, null)
        canvas.drawBitmap(bitmap1!!, 0f, (bitmap1!!.height + 20).toFloat(), paint)
        // 第三个：PorterDuff.Mode.DST_OUT
        val xfermode3: Xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        paint.xfermode = xfermode3
        canvas.drawBitmap(bitmap2!!, 0f, (bitmap1!!.height + 20).toFloat(), paint)
        paint.xfermode = null
        canvas.restoreToCount(saved3)

        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
    }

    init {
        bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    }
}