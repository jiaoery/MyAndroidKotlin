package com.example.myandroidkotlin.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService

/**
 * ClassName: NetWorkReciever<br/>
 * Description: TODO Description. <br/>
 * date: 2021/2/9 14:33<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class NetWorkReciever:BroadcastReceiver() {

    private val TAG = "NetWork"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(ConnectivityManager.CONNECTIVITY_ACTION==intent?.action){

            //网络改变
            Log.i(TAG,"NETWORK_CHANGE")
            val connectivityManager =
                context?.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivityManager.activeNetworkInfo
            if (info != null && info.isConnected) {
                val type = info.type
                Log.i(TAG,"network isconnected ,type is $type")
            } else {
                Log.i(TAG,"network disconnected ,type is -1")
            }
        }
    }
}