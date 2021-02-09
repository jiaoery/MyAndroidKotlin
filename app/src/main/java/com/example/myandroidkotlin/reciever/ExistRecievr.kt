package com.example.myandroidkotlin.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myandroidkotlin.BuildConfig
import kotlin.system.exitProcess

/**
 * ClassName: ExistRecievr<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/9 10:48<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class ExistRecievr:BroadcastReceiver() {

    //自定义的退出程序的广播
    val EXIT_ACTION = "${BuildConfig.APPLICATION_ID}.EXIT_APP"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(EXIT_ACTION == intent?.action){
            exitProcess(0)
        }
    }
}