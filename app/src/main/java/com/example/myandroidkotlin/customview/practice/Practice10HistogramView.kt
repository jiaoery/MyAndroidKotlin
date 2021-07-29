package com.example.myandroidkotlin.customview.practice

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class Practice10HistogramView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.WHITE
        paint.strokeWidth = dp2px(1f)
        canvas.drawLine(100f, 100f, 100f, 600f, paint)
        canvas.drawLine(100f, 600f, 1000f, 600f, paint)
        canvas.drawRect(150f, 595f, 250f, 600f, paint)
        paint.color = Color.parseColor("#8BB92F")
        canvas.drawRect(300f, 580f, 400f, 600f, paint)
        canvas.drawRect(450f, 560f, 550f, 600f, paint)
        canvas.drawRect(600f, 520f, 700f, 600f, paint)
        canvas.drawRect(750f, 480f, 850f, 600f, paint)
        canvas.drawRect(900f, 420f, 1000f, 600f, paint)
        paint.textSize = sp2px(8f)
        paint.color = Color.WHITE
        canvas.drawText("Froyo", 180f, 620f, paint)
        canvas.drawText("GB", 330f, 620f, paint)
        canvas.drawText("ICS", 480f, 620f, paint)
        canvas.drawText("JB", 630f, 620f, paint)
        canvas.drawText("KiKat", 780f, 620f, paint)
        canvas.drawText("L", 930f, 620f, paint)
        paint.textSize = sp2px(18f)
        canvas.drawText("直方图", 500f, 700f, paint)
        //        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }

    private fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            Resources.getSystem().displayMetrics
        )
    }

    private fun sp2px(sp: Float): Float {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            sp,
            Resources.getSystem().displayMetrics
        )
    }
}