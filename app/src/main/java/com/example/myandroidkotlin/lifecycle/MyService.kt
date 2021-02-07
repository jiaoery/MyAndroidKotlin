package com.example.myandroidkotlin.lifecycle

import android.util.Log
import androidx.lifecycle.LifecycleService

/**
 * ClassName: MyService<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/7 16:00<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class MyService : LifecycleService() {

    private val myServiceObserver = MyServiceObserver()

    init {
        lifecycle.addObserver(myServiceObserver)
    }


    override fun onCreate() {
        super.onCreate()
        Log.d("MyService","oncreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService","ondestroy")
    }
}