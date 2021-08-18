package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.utils.dp

class XformodeView @JvmOverloads constructor(context: Context, attrs: AttributeSet?=null, defStyleAttr: Int=0)
    : View(context, attrs, defStyleAttr)  {

    val paint =  Paint(Paint.ANTI_ALIAS_FLAG)
    val xfermode: Xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val saveLayer = canvas.saveLayer(null, null)
        canvas.drawOval(20f.dp,20f.dp,220f.dp,220f.dp,paint)
        paint.xfermode =xfermode
        canvas.drawBitmap(getAvatar(200f.dp.toInt()),20f.dp,20f.dp,paint)
        canvas.restoreToCount(saveLayer)
    }

    fun getAvatar(width:Int):Bitmap{
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.kai,options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,R.drawable.kai,options)
    }
}