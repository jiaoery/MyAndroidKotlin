package com.example.myandroidkotlin.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.utils.Utils


/**
 * ClassName: GestureRollView<br/>
 * Description: 仿华为时间选择控件
 * date: 2021/4/21 10:50<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class GestureRollView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var lineWidth:Float=0f

    private var lineColor:Int=0

    //曲线画笔
    private val cruveLinePaint:Paint = Paint()
    // 小白圆画笔
    private val circlePaint:Paint = Paint()
    // 时间数字画笔
    private val textPaint: Paint = Paint()

    private var viewWidth = 0f
    private var timeTextX1 = 0f
    private  var timeTextX2:Float = 0f
    private  var timeTextX3:Float = 0f
    private  var timeTextX4:Float = 0f
    private  var timeTextX5:Float = 0f
    //圆心X坐标
    private var circleCenterX = 0f
    //圆心Y坐标
    private var circleCenterY = 0f

    private var circleRadius = 30f //圆的半径

    private val linePath: Path = Path() //小圆上面的曲线path


    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GestureRollView)
        lineWidth =
            typedArray.getDimensionPixelOffset(R.styleable.GestureRollView_line_width, 1).toFloat()
        lineColor = typedArray.getColor(R.styleable.GestureRollView_line_color, -0x1)
        cruveLinePaint.style = Paint.Style.FILL
        cruveLinePaint.isAntiAlias = true
        cruveLinePaint.strokeWidth = Utils.dpToPx(lineWidth)
        cruveLinePaint.color = lineColor


        circlePaint.style = Paint.Style.FILL
        cruveLinePaint.isAntiAlias = true
        circlePaint.strokeWidth = 1f
        circlePaint.color = -0x1

        textPaint.isAntiAlias = true
        textPaint.textSize = Utils.spToPx(10f)
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.color = -0x99999a
    }

    //重新测量
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        viewWidth = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        circleCenterX = (MeasureSpec.getSize(widthMeasureSpec) / 2).toFloat()
        circleCenterY = (MeasureSpec.getSize(heightMeasureSpec) - circleRadius * 2)
        timeTextX1 = (circleRadius * 3)
        timeTextX2 = ((viewWidth / 2 + circleRadius * 3) / 2)
        timeTextX3 = (viewWidth / 2)
        timeTextX4 = ((viewWidth - circleRadius * 3 + viewWidth / 2) / 2)
        timeTextX5 = (viewWidth - circleRadius * 3)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制手势圆
        canvas.drawCircle(circleCenterX, circleCenterY, circleRadius, circlePaint)

        drawLine(canvas)

        drawText(canvas)
    }
    //绘制滑动线
    private fun drawLine(canvas: Canvas){
        linePath.reset()
        linePath.moveTo(0f, circleCenterY)
        linePath.lineTo(circleCenterX - circleRadius - 60, circleCenterY)
        //一开始二阶贝塞尔曲线的绘制
        linePath.cubicTo(
            circleCenterX - circleRadius,
            circleCenterY,
            circleCenterX - circleRadius - 5,
            circleCenterY - circleRadius - 10,
            circleCenterX,
            circleCenterY - circleRadius - 10
        )
        linePath.cubicTo(
            circleCenterX + circleRadius + 5,
            circleCenterY - circleRadius - 10,
            circleCenterX + circleRadius,
            circleCenterY,
            circleCenterX + circleRadius + 60,
            circleCenterY
        )
        linePath.lineTo(viewWidth, circleCenterY)
        linePath.lineTo(viewWidth, 0f)
        linePath.lineTo(0f, 0f)
        linePath.close()
        canvas.drawPath(linePath, cruveLinePaint)

    }

    //绘制文本
    private fun drawText(canvas: Canvas){
        doDrawText(canvas, "09/07", "20:00", timeTextX1);
        doDrawText(canvas, null, "02:00", timeTextX2);
        doDrawText(canvas, null, "08:00", timeTextX3);
        doDrawText(canvas, null, "14:00", timeTextX4);
        doDrawText(canvas, "09/08", "20:00", timeTextX5);

    }

    /**
     * 绘制时间随手势滚轮上下移动逻辑
     *
     * @param canvas
     * @param date
     * @param time
     * @param timeTextX
     */
    private fun doDrawText(canvas: Canvas, date: String?, time: String, timeTextX: Float) {
        if (Math.abs(circleCenterX - timeTextX) < 50) {
            canvas.drawText(time, timeTextX, circleCenterY - circleRadius - 25, textPaint)
            if (date == null) return
            canvas.drawText(date, timeTextX, circleCenterY - circleRadius - 53, textPaint)
        } else if (Math.abs(circleCenterX - timeTextX) > 110) {
            canvas.drawText(time, timeTextX, circleCenterY - 10, textPaint)
            if (date == null) return
            canvas.drawText(date, timeTextX, circleCenterY - 38, textPaint)
        } else {
            canvas.drawText(
                time,
                timeTextX,
                (circleRadius + 15) * (Math.abs(circleCenterX - timeTextX) - 50) / 60 + (circleCenterY - circleRadius - 25),
                textPaint
            )
            if (date == null) return
            canvas.drawText(
                date,
                timeTextX,
                (circleRadius + 15) * (Math.abs(circleCenterX - timeTextX) - 50) / 60 + (circleCenterY - circleRadius - 53),
                textPaint
            )
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                if (event.x < circleRadius || event.x > viewWidth - circleRadius)
                    return super.onTouchEvent(event)
                circleCenterX = event.x
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> if (event.x < viewWidth - circleRadius && event.x > circleRadius) {
                circleCenterX = event.x
                invalidate()
            }
        }
        return true
    }


}