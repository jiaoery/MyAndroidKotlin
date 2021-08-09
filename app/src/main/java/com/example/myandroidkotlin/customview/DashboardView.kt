package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.utils.dp
import kotlin.math.cos
import kotlin.math.sin


private const val OPEN_ANGEl =120f
private val MARK = 10
private val RADIUS = 150f.dp
private val LENGTH =120f.dp
private val DASH_WIDTH = 2f.dp
private val DASH_HEIGHT = 10f.dp
class DashboardView(context:Context?,attrs: AttributeSet?):View(context,attrs) {

    private val paint  = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dash = Path()
    private val path =Path()
    private lateinit var pathDashPathEffect:PathDashPathEffect
    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 3f.dp
        dash.addRect(0f,0f, DASH_WIDTH, DASH_HEIGHT,Path.Direction.CW)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(width/2- RADIUS,height/2- RADIUS,width/2+ RADIUS,height/2+ RADIUS,
            90f+ OPEN_ANGEl/2,240f)
        val pathMeasure = PathMeasure(path, false)
        pathDashPathEffect = PathDashPathEffect(dash, (pathMeasure.length - DASH_WIDTH)/20, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path,paint)
        paint.pathEffect = pathDashPathEffect
        canvas.drawPath(path,paint)
        paint.pathEffect = null
        canvas.drawLine(
            width / 2f,
            height / 2f,
            (width / 2f + LENGTH * cos(markToRandians(MARK)).toFloat()),
            (height / 2f + LENGTH * sin(markToRandians(MARK))).toFloat(),
            paint
        )
    }

    private fun markToRandians(mark:Int):Double{
        return Math.toRadians((90 + OPEN_ANGEl / 2f + mark * (360 - OPEN_ANGEl) / 20f).toDouble())
    }
}