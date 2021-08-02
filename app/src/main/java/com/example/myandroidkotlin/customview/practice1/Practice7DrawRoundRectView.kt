package com.example.myandroidkotlin.customview.practice1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View

class Practice7DrawRoundRectView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr) {
    var paint = Paint()
    var rectF = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(
                width.toFloat() / 2 - 200f,
                height.toFloat() / 2 - 100f,
                width.toFloat() / 2 + 200f,
                height.toFloat() / 2 + 100f,
                50f,
                50f,
                paint
            )
        } else {
            rectF.left = width.toFloat() / 2 - 200f
            rectF.top = height.toFloat() / 2 - 100f
            rectF.right = width.toFloat() / 2 + 200f
            rectF.bottom = height.toFloat() / 2 + 100f
            canvas.drawRoundRect(rectF, 50f, 50f, paint)
        }
        //        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
    }
}