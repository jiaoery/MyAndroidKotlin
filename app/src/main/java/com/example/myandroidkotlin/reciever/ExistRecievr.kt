package com.example.myandroidkotlin.reciever

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
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

    companion object{
        //自定义的退出程序的广播
       const val CLEAR_ACTION = "${BuildConfig.APPLICATION_ID}.CLEAR_APP"
    }


    override fun onReceive(context: Context, intent: Intent?) {
        if(CLEAR_ACTION == intent?.action){
            val notificationManager: NotificationManager =
                context.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.cancelAll()
        }
    }
}