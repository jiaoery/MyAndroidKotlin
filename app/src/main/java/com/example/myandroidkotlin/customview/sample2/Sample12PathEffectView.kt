package com.example.myandroidkotlin.customview.sample2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Sample12PathEffectView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path()
    var cornerPathEffect: PathEffect = CornerPathEffect(20f)
    var discretePathEffect: PathEffect = DiscretePathEffect(20f, 5f)
    var dashPathEffect: PathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 0f)
    var pathDashPathEffect: PathEffect? = null
    var sumPathEffect: PathEffect = SumPathEffect(dashPathEffect, discretePathEffect)
    var composePathEffect: PathEffect = ComposePathEffect(dashPathEffect, discretePathEffect)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // CornerPathEffect
        paint.pathEffect = cornerPathEffect
        canvas.drawPath(path, paint)
        canvas.save()
        canvas.translate(500f, 0f)
        // DiscretePathEffect
        paint.pathEffect = discretePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 200f)
        // DashPathEffect
        paint.pathEffect = dashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 200f)
        // PathDashPathEffect
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(0f, 400f)
        // SumPathEffect
        paint.pathEffect = sumPathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        canvas.save()
        canvas.translate(500f, 400f)
        // ComposePathEffect
        paint.pathEffect = composePathEffect
        canvas.drawPath(path, paint)
        canvas.restore()
        paint.pathEffect = null
    }

    init {
        paint.style = Paint.Style.STROKE
        path.moveTo(50f, 100f)
        path.rLineTo(50f, 100f)
        path.rLineTo(80f, -150f)
        path.rLineTo(100f, 100f)
        path.rLineTo(70f, -120f)
        path.rLineTo(150f, 80f)
        val dashPath = Path()
        dashPath.lineTo(20f, -30f)
        dashPath.lineTo(40f, 0f)
        dashPath.close()
        pathDashPathEffect = PathDashPathEffect(dashPath, 50f, 0f, PathDashPathEffect.Style.MORPH)
    }
}