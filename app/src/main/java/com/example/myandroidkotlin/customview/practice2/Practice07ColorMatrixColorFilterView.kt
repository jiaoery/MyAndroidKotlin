package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice07ColorMatrixColorFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap!!, 0f, 0f, paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

        // 使用 setColorFilter() 设置一个 ColorMatrixColorFilter
        // 用 ColorMatrixColorFilter.setSaturation() 把饱和度去掉
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val filter: ColorFilter = ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = filter
    }
}