package com.example.myandroidkotlin.customview.practice2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.myandroidkotlin.R

class Practice05ComposeShaderView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(200f, 200f, 200f, paint)
    }

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null) // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader
        // 第一个 Shader：头像的 Bitmap
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
        val shader1: Shader = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
        val shader2: Shader = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN)
        paint.shader = shader
        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }
}