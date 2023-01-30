package com.example.myandroidkotlin.saveinstance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myandroidkotlin.R

class SaveInstanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_instance)
        if(savedInstanceState != null){
            val tempData = savedInstanceState.getString("data_key")
            tempData?.let{ data -> Log.d(TAG, data) }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val tempData = "Something you just typed"
        outState.putString("data_key",tempData)
    }

    companion object{
        val TAG = SaveInstanceActivity::class.simpleName
    }

}