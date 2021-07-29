package com.example.myandroidkotlin.customview.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice3DrawRectView @JvmOverloads constructor(context: Context?, attrs: AttributeSet?=null, defStyleAttr: Int=0): View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(
            width / 2 - 180f,
            height / 2 - 180f,
            width / 2 + 180f,
            height / 2 + 180f,
            paint
        )
        //        练习内容：使用 canvas.drawRect() 方法画矩形
    }
}