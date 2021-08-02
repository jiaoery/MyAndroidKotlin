package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice14MaskFilterView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        canvas.drawBitmap(bitmap!!, 100f, 50f, paint)

        // 第二个：INNER
        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
        canvas.drawBitmap(bitmap!!, (bitmap!!.width + 200).toFloat(), 50f, paint)

        // 第三个：OUTER
        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
        canvas.drawBitmap(bitmap!!, 100f, (bitmap!!.height + 100).toFloat(), paint)

        // 第四个：SOLID
        paint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
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