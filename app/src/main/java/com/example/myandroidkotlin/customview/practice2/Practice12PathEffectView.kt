package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice12PathEffectView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect
        val effect1: PathEffect = CornerPathEffect(20f)
        paint.pathEffect = effect1
        // 第一处：CornerPathEffect
        canvas.drawPath(path, paint)
        canvas.save()
        canvas.translate(500f, 0f)
        // 第二处：DiscretePathEffect
        val effect2: PathEffect = DiscretePathEffect(20f, 5f)
        paint.pathEffect = effect2
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 200f)
        // 第三处：DashPathEffect
        val pathEffect3: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
        paint.pathEffect = pathEffect3
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 200f)
        // 第四处：PathDashPathEffect
        val dashPath = Path() // 使用一个三角形来做 dash
        dashPath.fillType = Path.FillType.EVEN_ODD
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        val pathEffect4: PathEffect = PathDashPathEffect(
            dashPath, 40f, 0f,
            PathDashPathEffect.Style.TRANSLATE
        )
        paint.pathEffect = pathEffect4
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 400f)
        // 第五处：SumPathEffect
        val dashEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f), 0f)
        val discreteEffect: PathEffect = DiscretePathEffect(20f, 5f)
        val pathEffect5: PathEffect = SumPathEffect(dashEffect, discreteEffect)
        paint.pathEffect = pathEffect5
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 400f)
        // 第六处：ComposePathEffect
        val pathEffect6: PathEffect = ComposePathEffect(dashEffect, discreteEffect)
        paint.pathEffect = pathEffect6
        canvas.drawPath(path, paint)
        canvas.restore()
    }

    init {
        paint.style = Paint.Style.STROKE
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)
    }
}