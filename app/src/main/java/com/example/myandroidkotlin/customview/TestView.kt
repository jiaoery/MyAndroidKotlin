package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.utils.dp
import com.example.myandroidkotlin.utils.sp

/**
 * ClassName: TestView<br/>
 * Description: 测试View
 * date: 2021/2/23 22:50<br/>
 *
 * @author Administrator
 * @version V1.0.0
 * @since JDK 1.8
 */
class TestView  @JvmOverloads constructor(context: Context, attributes: AttributeSet?=null,defStyleAttr:Int=0) :
    AppCompatTextView(context, attributes,defStyleAttr) {


    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var path: Path = Path() // 初始化 Path 对象
    private val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.icon)


    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
            path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false)
            path.lineTo(400f, 542f)
        }


    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawColor(Color.WHITE)
        paint.color = Color.BLACK
        canvas.drawLine(100f, 100f, 180f, 180f, paint)
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 200f, paint)

        paint.style = Paint.Style.STROKE
        paint.isAntiAlias
        paint.strokeWidth = 3f.dp
        canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), 300f, paint)

        paint.style = Paint.Style.FILL
        paint.strokeWidth = 1f.dp
        canvas.drawRect(200f, 200f, 500f, 500f, paint)

        paint.style = Paint.Style.STROKE
        canvas.drawRect(700f, 200f, 1000f, 500f, paint)


        paint.strokeWidth = 20f.dp
        paint.strokeCap = Paint.Cap.ROUND
        paint.color = Color.BLACK
        canvas.drawPoint(50f, 50f, paint)

        paint.strokeWidth = 20f.dp
        paint.strokeCap = Paint.Cap.SQUARE
        canvas.drawPoint(150f, 50f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeWidth = 5f.dp
        val listPoints:FloatArray = floatArrayOf(0f, 0f, 250f, 50f, 250f, 100f, 300f, 50f, 300f, 100f, 350f, 50f, 350f, 100f)
        /* 跳过两个数，即前两个 0 ;一共绘制 8 个数（4 个点）*/
        canvas.drawPoints(listPoints,2,8,paint)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.style = Paint.Style.FILL
            paint.strokeWidth = 1f.dp
            canvas.drawOval(400f, 50f, 700f, 180f, paint)
            paint.style = Paint.Style.STROKE
            canvas.drawOval(750f, 50f, 1050f, 180f, paint)
        }

        val points:FloatArray = floatArrayOf(20f, 20f, 120f, 20f, 70f, 20f,
            70f, 120f, 20f, 120f, 120f, 120f, 150f, 20f, 250f, 20f, 150f,
            20f, 150f, 120f, 250f, 20f, 250f, 120f, 150f, 120f, 250f, 120f)
        canvas.drawLines(points, paint)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100f, 100f, 500f, 300f, 50f, 50f, paint)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            paint.style = Paint.Style.FILL // 填充模式
            canvas.drawArc(200f, 100f, 800f, 500f, -110f, 100f, true, paint)// 绘制扇形
            canvas.drawArc(200f, 100f, 800f, 500f, 20f, 140f, false, paint)// 绘制弧形
            paint.style = Paint.Style.STROKE; // 画线模式
            canvas.drawArc(200f, 100f, 800f, 500f, 180f, 60f, false, paint)// 绘制不封口的弧形
        }

        //heart path
        paint.color = Color.RED
        canvas.drawPath(path, paint) // 绘制出 path 描述的图形（心形），大功告成

        paint.textSize = 24f.sp
        canvas.drawText("I LOVE YOU ,JIAOJIAO",0,20,150f,600f,paint)


        canvas.drawBitmap(bitmap, 100f, 700f, paint)



    }
}