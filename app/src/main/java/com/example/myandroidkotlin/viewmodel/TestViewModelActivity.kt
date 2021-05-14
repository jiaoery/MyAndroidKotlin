package com.example.myandroidkotlin.viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myandroidkotlin.R

class TestViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view_model)
    }

    fun onClick(view:View){
        when(view.id){
            R.id.button->startActivity(Intent(this@TestViewModelActivity,ViewModelAcivity::class.java))
                R.id.button2->startActivity(Intent(this@TestViewModelActivity,CrossViewModelActivity::class.java))
        }
    }
}