package com.example.myandroidkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timerTask

/**
 * ClassName: MyViewModel<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/13 14:37<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class MyViewModel : ViewModel() {

    private var timer: Timer = Timer()

    private var currentSecond = 0

    private var timerTask: TimerTask = timerTask {
        currentSecond++
        if (onTimeChangedListener!=null){
            onTimeChangedListener!!.onTimeChanged(currentSecond)
        }
    }

    fun startTimeing() {
        timer.schedule(timerTask,1000,1000)
    }

    interface OnTimeChangedListener {
        fun onTimeChanged(second: Int)
    }

    private var onTimeChangedListener: OnTimeChangedListener? = null

    fun setOnTimeChangedListener(onTimeChangedListener: OnTimeChangedListener) {
        this.onTimeChangedListener = onTimeChangedListener
    }



    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.
    }


    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}


