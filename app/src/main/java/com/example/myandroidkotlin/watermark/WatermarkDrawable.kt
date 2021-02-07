package com.example.myandroidkotlin.watermark

import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.Paint
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import androidx.annotation.IntRange
import com.example.myandroidkotlin.utils.Utils
import kotlin.math.sqrt


/**
 * ClassName: WatermarkDrawable<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/2 17:10<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class WatermarkDrawable: Drawable() {

    private var mPaint: Paint = Paint()

    /**
     * 水印文本
     */
    @JvmField
    public var mText: String = "ipipip"

    /**
     * 字体颜色，十六进制形式，例如：0xAEAEAEAE
     */
    @JvmField
    var mTextColor = 0x000000

    /**
     * 字体大小，单位为sp
     */
    @JvmField
    var mTextSize:Float = 12f

    /**
     * 旋转角度
     */
    @JvmField
    var mRotation = 0f

    override fun draw(canvas: Canvas) {
        val width = bounds.right
        val height = bounds.bottom
        // 对角线的长度
        val diagonal = sqrt((width * width + height * height).toDouble()).toInt()

        mPaint.color = mTextColor
        mPaint.textSize = Utils.spToPx(mTextSize)
        mPaint.isAntiAlias = true

        //测绘文字需要的长度
        val textWidth = mPaint.measureText(mText)
        canvas.drawColor(0x000000)
        canvas.rotate(mRotation)

        var index = 0
        var fromX: Int
        // 以对角线的长度来做高度，这样可以保证竖屏和横屏整个屏幕都能布满水印
        run {
            var positionY = diagonal / 10
            //垂直路径下绘制
            while (positionY <= diagonal) {
                // 上下两行的X轴起始点不一样，错开显示
                fromX = (-width + index++ % 2 * textWidth).toInt()
                var positionX = fromX.toFloat()
                //水平路径下绘制
                while (positionX < width) {
                    canvas.drawText(mText, positionX, positionY.toFloat(), mPaint)
                    positionX += textWidth * 2
                }
                positionY += diagonal / 20
            }
        }

        canvas.save()
        canvas.restore()
    }

    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {}

    override fun setColorFilter(colorFilter: ColorFilter?) {}

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

}