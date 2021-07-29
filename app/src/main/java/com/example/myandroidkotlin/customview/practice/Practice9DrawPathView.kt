package com.example.myandroidkotlin.customview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.util.AttributeSet
import android.view.View

class Practice9DrawPathView : View {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var path = Path() // 初始化 Path 对象

    constructor(context: Context?) : super(context) {}

    @JvmOverloads
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int = 0) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(100f, 100f, 200f, 200f, -225f, 225f)
            path.arcTo(200f, 100f, 300f, 200f, -180f, 225f, false)
            path.lineTo(200f, 271f)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
        //        练习内容：使用 canvas.drawPath() 方法画心形
    }
}