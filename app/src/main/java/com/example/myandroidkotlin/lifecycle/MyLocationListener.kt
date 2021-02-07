package com.example.myandroidkotlin.lifecycle

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * ClassName: MyLocationListener<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/7 14:36<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class MyLocationListener(context: Context, onLocationChangeLister: OnLocationChangedListener) : LifecycleObserver {

    init {
        initLocationManager()
    }

    /**
     * 初始化定位管理器
     */
    fun initLocationManager(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun statGetLocation()= Log.d("MyLocationListener","startGetLocation")

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation()= Log.d("MyLocationListener","stopGetLocation")
}