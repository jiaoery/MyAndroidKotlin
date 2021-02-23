package com.example.myandroidkotlin.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

/**
 * ClassName: TestView<br/>
 * Description: 测试View
 * date: 2021/2/23 22:50<br/>
 *
 * @author Administrator
 * @version V1.0.0
 * @since JDK 1.8
 */
class TestView(context: Context, attributes: AttributeSet?): AppCompatTextView(context,attributes) {


     val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawLine(100f,100f,200f,200f,paint)
        canvas.drawCircle((width/2).toFloat(), (height/2).toFloat(),200f,paint)
    }
}