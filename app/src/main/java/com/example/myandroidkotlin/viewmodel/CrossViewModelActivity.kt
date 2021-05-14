package com.example.myandroidkotlin.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.viewmodel.ui.main.CrossViewModelFragment
import com.example.myandroidkotlin.viewmodel.ui.main.CrossViewModelFragment1

class CrossViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cross_view_model_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, CrossViewModelFragment.newInstance())
                .replace(R.id.container2, CrossViewModelFragment1.newInstance())
                .commitNow()
        }
    }
}