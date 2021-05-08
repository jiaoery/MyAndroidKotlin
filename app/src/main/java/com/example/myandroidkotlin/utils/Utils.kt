package com.example.myandroidkotlin.utils

import android.content.res.Resources
import android.util.TypedValue

/**
 * ClassName: Utils<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/2 17:31<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
object Utils {


    /**
     * Value of sp to value of px.
     *
     * @param spValue The value of sp.
     * @return value of px
     */
    fun spToPx(spValue: Float)=
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,spValue,Resources.getSystem().displayMetrics)


    /**
     * value dp to px
     * @param dpValue the value of dp
     * @return value of px
     */
    fun dpToPx(dpValue: Float)=
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dpValue,Resources.getSystem().displayMetrics)



}