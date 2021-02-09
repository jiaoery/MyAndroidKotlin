package com.example.myandroidkotlin

import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkRequest
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidkotlin.reciever.ExistRecievr
import com.example.myandroidkotlin.reciever.NetWorkReciever
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
        const val EXIT_ACTION = "${BuildConfig.APPLICATION_ID}.EXIT_APP"
    }

    private lateinit var exitReceiver:BroadcastReceiver
    private lateinit var networkReceiver: BroadcastReceiver
    private lateinit var mConnectivityManager:ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitReceiver = ExistRecievr()
        val filter = IntentFilter()
        filter.addAction(EXIT_ACTION)
        registerReceiver(exitReceiver, filter) //注册广播接收器
        Log.d(TAG, "进入页面：$this")
        Watermark.show(this, "jiaoery")
        //网络变化监听器
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            mConnectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkCallbackImpl = NetworkCallbackImpl()
            mConnectivityManager.requestNetwork(NetworkRequest.Builder().build(),networkCallbackImpl)
        }else{
            networkReceiver =  NetWorkReciever()
            val netFilter = IntentFilter()
            netFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
            registerReceiver(networkReceiver,netFilter)

        }


    }



}