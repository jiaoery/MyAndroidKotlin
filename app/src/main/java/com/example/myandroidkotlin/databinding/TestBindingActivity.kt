package com.example.myandroidkotlin.databinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ui.PlainOldActivity
import com.example.myandroidkotlin.databinding.ui.SolutionActivity
import com.example.myandroidkotlin.databinding.viewmodel.SimpleViewModel

class TestBindingActivity : AppCompatActivity() {

    private val viewModel:SimpleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_binding)
    }

    fun onClick(view: View){
        when(view.id){
            //原始用法
            R.id.btn_normal->startActivity(Intent(this,PlainOldActivity::class.java))
            //高级用法
            R.id.btn_databinding ->startActivity(Intent(this,SolutionActivity::class.java))
        }
    }
}