package com.example.myandroidkotlin.lifecycle

/**
 * ClassName: OnLocationChangedListener<br/>
 * Description: 定位信息改变的监听器
 * date: 2021/2/7 14:37<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
interface OnLocationChangedListener {
    /**
     * 定位信息改变
     * @param latitude 纬度
     * @param longitude 经度
     */
    fun onChanged(latitude: Double,longitude:Double)
}