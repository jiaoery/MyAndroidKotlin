package com.example.myandroidkotlin

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi

/**
 * ClassName: NetworkCallbackImpl<br/>
 * Description: 网络监听回调 适用于5.0系统以上
 * date: 2021/2/9 11:42<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class NetworkCallbackImpl: ConnectivityManager.NetworkCallback() {


    val TAG = "NetworkCallbackImpl"

    override fun onAvailable(network: Network) {
        super.onAvailable(network)
        Log.i(TAG,"网络已链接")
    }

    override fun onLost(network: Network) {
        super.onLost(network)
        Log.i(TAG,"网络已断开")
    }


    override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities)
        if (networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)) {
            when {
                //WIFFI
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    Log.i(TAG,"wifi已经连接")
                }
                //数据流量
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    Log.i(TAG,"数据流量已经连接")
                }
                else -> {
                    Log.i(TAG,"其他网络")
                }
            }
        }

    }
}