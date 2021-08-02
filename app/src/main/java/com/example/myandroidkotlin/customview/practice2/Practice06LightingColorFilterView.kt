package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice06LightingColorFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        val filter: ColorFilter = LightingColorFilter(0x00ffff, 0x000000)
        paint.colorFilter = filter
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(bitmap!!, 0f, 0f, paint)

        // 第二个 LightingColorFilter：增强绿色部分
        val filter1: ColorFilter = LightingColorFilter(0xffffff, 0x003000)
        paint.colorFilter = filter1
        canvas.drawBitmap(bitmap!!, (bitmap!!.width + 100).toFloat(), 0f, paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    }
}