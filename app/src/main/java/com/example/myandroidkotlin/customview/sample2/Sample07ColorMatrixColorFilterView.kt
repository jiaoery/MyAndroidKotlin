package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Sample07ColorMatrixColorFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap!!, 0f, 0f, paint)
    }

    init {
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        val colorFilter: ColorFilter = ColorMatrixColorFilter(colorMatrix)
        paint.colorFilter = colorFilter
    }
}