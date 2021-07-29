package com.example.myandroidkotlin.customview.practice

import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.RequiresApi

class Practice11PieChartView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0) : View (context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.YELLOW
        canvas.drawArc(100f, 100f, 600f, 600f, -60f, 60f, true, paint)
        canvas.drawArc(100f, 100f, 600f, 600f, 5f, 15f, true, paint)
        paint.color = Color.GRAY
        canvas.drawArc(100f, 100f, 600f, 600f, 25f, 15f, true, paint)
        paint.color = Color.BLUE
        canvas.drawArc(100f, 100f, 600f, 600f, 45f, 40f, true, paint)
        canvas.drawArc(100f, 100f, 600f, 600f, 90f, 90f, true, paint)
        paint.color = Color.RED
        canvas.drawArc(80f, 80f, 580f, 580f, 180f, 120f, true, paint)
        paint.textSize = sp2px(8f)
        paint.color = Color.WHITE
        paint.strokeWidth = dp2px(2f)
        drawLineAndText(canvas, 350f, 350f, 250f, 50f, -30f, "Marshmallow")
        drawLineAndText(canvas, 350f, 350f, 250f, 50f, 12.5f, "Froyo")
        drawLineAndText(canvas, 350f, 350f, 250f, 50f, 32.5f, "Ice Cream Sandwich")
        drawLineAndText(canvas, 350f, 350f, 250f, 50f, 65f, "Jelly Beam")
        drawLineAndText(canvas, 350f, 350f, 250f, 50f, 135f, "KitKat")
        drawLineAndText(canvas, 330f, 330f, 250f, 50f, 240f, "Lollipop")
        paint.textSize = sp2px(18f)
        canvas.drawText("饼图", 400f, 700f, paint)


//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
    }

    private fun drawLineAndText(
        canvas: Canvas,
        centerX: Float,
        centerY: Float,
        raduis: Float,
        offset: Float,
        angel: Float,
        text: String
    ) {
        canvas.drawLine(
            (centerX + raduis * cos(angel)).toFloat(),
            (centerY + raduis * sin(angel)).toFloat(),
            (centerX + (raduis + offset) * cos(angel)).toFloat(),
            (centerY + (raduis + offset) * sin(angel)).toFloat(),
            paint
        )
        if (cos(angel) >= 0) {
            canvas.drawLine(
                (centerX + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                (centerX + offset + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                paint
            )
            canvas.drawText(
                text,
                (centerX + offset + 5 + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                paint
            )
        } else {
            canvas.drawLine(
                (centerX + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                (centerX - offset + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                paint
            )
            canvas.drawText(
                text,
                (centerX - offset - 80 + (raduis + offset) * cos(angel)).toFloat(),
                (centerY + (raduis + offset) * sin(angel)).toFloat(),
                paint
            )
        }
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

    fun sin(i: Float): Double {
        var result = 0.0
        result = Math.sin(i * StrictMath.PI / 180)
        return result
    }

    fun cos(i: Float): Double {
        var result = 0.0
        result = Math.cos(i * StrictMath.PI / 180)
        return result
    }
}