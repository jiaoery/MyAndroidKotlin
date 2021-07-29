package com.example.myandroidkotlin.customview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build
import android.util.AttributeSet
import android.view.View

class Practice8DrawArcView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var rectF = RectF(300f, 100f, 660f, 340f)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(
                width.toFloat() / 2 - 180f,
                height.toFloat() / 2 - 120f,
                width.toFloat() / 2 + 180f,
                height.toFloat() / 2 + 120f,
                -110f,
                100f,
                true,
                paint
            ) // 绘制扇形
            canvas.drawArc(
                width.toFloat() / 2 - 180f,
                height.toFloat() / 2 - 120f,
                width.toFloat() / 2 + 180f,
                height.toFloat() / 2 + 120f,
                20f,
                140f,
                false,
                paint
            ) // 绘制弧形
            paint.style = Paint.Style.STROKE
            canvas.drawArc(
                width.toFloat() / 2 - 180f,
                height.toFloat() / 2 - 120f,
                width.toFloat() / 2 + 180f,
                height.toFloat() / 2 + 120f,
                180f,
                60f,
                false,
                paint
            )
        } else {
            rectF.left = width.toFloat() / 2 - 180f
            rectF.top = height.toFloat() / 2 - 120f
            rectF.right = width.toFloat() / 2 + 180f
            rectF.bottom = height.toFloat() / 2 + 120f
            canvas.drawArc(rectF, -110f, 100f, true, paint) // 绘制扇形
            canvas.drawArc(rectF, 20f, 140f, false, paint) // 绘制弧形
            paint.style = Paint.Style.STROKE
            canvas.drawArc(rectF, 180f, 60f, false, paint)
        }

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
    }
}