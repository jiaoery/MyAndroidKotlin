package com.example.myandroidkotlin.customview.practice1

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
 class Practice2DrawCircleView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        canvas.drawCircle(width.toFloat() / 4, height.toFloat() / 4, 160f, paint)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dp2px(2f)
        canvas.drawCircle((width.toFloat() * 0.75).toFloat(), height.toFloat() / 4, 160f, paint)
        paint.color = Color.parseColor("#5990E6")
        paint.style = Paint.Style.FILL
        canvas.drawCircle(width.toFloat() / 4, (height.toFloat() * 0.75).toFloat(), 160f, paint)
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dp2px(20f)
        canvas.drawCircle(
            (width.toFloat() * 0.75).toFloat(),
            (height.toFloat() * 0.75).toFloat(),
            160f,
            paint
        )
    }

    private fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            Resources.getSystem().displayMetrics
        )
    }
}