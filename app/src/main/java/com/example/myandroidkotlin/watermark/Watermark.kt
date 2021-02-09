package com.example.myandroidkotlin.watermark

import android.R
import android.app.Activity
import android.view.ViewGroup
import android.widget.FrameLayout
import java.lang.RuntimeException


/**
 * ClassName: Watermark<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/2 16:46<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
object Watermark {
    /**
     * 水印文本
     */

    var mText: String = "ipipip"

    /**
     * 字体颜色，十六进制形式，例如：0xAEAEAEAE
     */
    var mTextColor =-0x51515152

    /**
     *
     * 字体大小，单位为sp
     */
    var mTextSize:Float = 18f

    /**
     * 旋转角度
     */
    var mRotation = -25f


    /**
     * 设置水印文本
     *
     * @param text 文本
     * @return Watermark实例
     */
    fun setText(text: String): Watermark {
        mText = text
        return this
    }

    /**
     * 设置字体颜色
     */
    fun setTextColor(textColor: Int):Watermark{
        mTextColor =textColor
        return this
    }

    /**
     * 设置字体大小
     */
    fun setTextSize(textSize: Float):Watermark{
        mTextSize = textSize
        return this
    }

    /**
     * 设置旋转角度
     */
    fun setRotate(rotate: Float):Watermark{
        mRotation = rotate
        return this
    }


    /**
     * 必须在setcontentview后被调用
     */
    @JvmOverloads
    fun show(activity: Activity, text: String = mText) {
        if(text.isEmpty()){
            throw RuntimeException("Text can not be null")
        }
        val drawable = WatermarkDrawable()
        drawable.mText = text
        drawable.mTextColor = mTextColor
        drawable.mTextSize = mTextSize
        drawable.mRotation = mRotation
        val rootView = activity.findViewById<ViewGroup>(R.id.content)
        val layout = FrameLayout(activity)
        layout.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layout.background = drawable
        rootView.addView(layout)
    }

}