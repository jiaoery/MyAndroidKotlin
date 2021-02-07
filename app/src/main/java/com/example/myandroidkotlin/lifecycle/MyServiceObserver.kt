package com.example.myandroidkotlin.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * ClassName: MyServiceObserver<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/7 16:01<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class MyServiceObserver:LifecycleObserver {

   private val TAG:String = javaClass.name

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun statGetLocation(){
        Log.d(TAG,"startGetLocation")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation(){
        Log.d(TAG,"stopGetLocation")
    }

}