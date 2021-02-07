package com.example.myandroidkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidkotlin.watermark.Watermark

/**
 * ClassName: BaseActivity<br/>
 * Description: TODO Description. <br/>
 * date: 2021/1/29 17:16<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
open class BaseActivity : AppCompatActivity() {

    companion object{
        /**
         * const 编译常量
         */
        val TAG = BaseActivity::class.simpleName
        const val EXIT_ACTION = "com.android.learning.EXIT_APP"
        const val NETWORK_CHANGE = ConnectivityManager.CONNECTIVITY_ACTION
    }

    private lateinit var exitReceiver:BroadcastReceiver

    lateinit var networkStatusChange:OnNetworkStatusChange

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitReceiver = MyReceiver()
        networkStatusChange = object : OnNetworkStatusChange {
            override fun onNetWorkStatusChanged(isAviable: Boolean, type: Int) {
                //类似BaseActivity.this
                this@BaseActivity.onNetWorkStatusChanged1(isAviable, type)
            }
        }
        val filter = IntentFilter()
        filter.addAction(EXIT_ACTION)
        filter.addAction(NETWORK_CHANGE)
        registerReceiver(exitReceiver, filter) //注册广播接收器

        Log.d(TAG,"进入页面：$this")
        Watermark.show(this, "jiaoery")

    }

    fun onNetWorkStatusChanged1(isAvailable: Boolean, type: Int){

    }


    inner class MyReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == EXIT_ACTION) {
                //接收到退出程序的广播

            } else if (intent.action == NETWORK_CHANGE) {
                //网络改变
                println("NETWORK_CHANGE")
                val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                val info = connectivityManager.activeNetworkInfo
                if (info != null && info.isConnected) {
                    val type = info.type
                    networkStatusChange.onNetWorkStatusChanged(true, type)
                } else {
                    networkStatusChange.onNetWorkStatusChanged(false, -1)
                }
            }
        }
    }
}