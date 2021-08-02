package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Sample14MaskFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null
    var maskFilter1: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
    var maskFilter2: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
    var maskFilter3: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
    var maskFilter4: MaskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.maskFilter = maskFilter1
        canvas.drawBitmap(bitmap!!, 100f, 50f, paint)
        paint.maskFilter = maskFilter2
        canvas.drawBitmap(bitmap!!, (bitmap!!.width + 200).toFloat(), 50f, paint)
        paint.maskFilter = maskFilter3
        canvas.drawBitmap(bitmap!!, 100f, (bitmap!!.height + 100).toFloat(), paint)
        paint.maskFilter = maskFilter4
        canvas.drawBitmap(
            bitmap!!,
            (bitmap!!.width + 200).toFloat(),
            (bitmap!!.height + 100).toFloat(),
            paint
        )
    }

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)
    }
}