package com.example.myandroidkotlin

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.didichuxing.doraemonkit.DoraemonKit
import com.example.myandroidkotlin.lifecycle.ApplicationObserver
import com.example.myandroidkotlin.rooms.AppDatabase

/**
 * ClassName: MyApplication<br/>
 * Description: TODO Description. <br/>
 * date: 2021/1/29 18:07<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class MyApplication :Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
        AppDatabase.create(this)
        DoraemonKit.install(this)
    }

}