package com.example.myandroidkotlin.launchmodel

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidkotlin.R

class SingleTaskActivity: AppCompatActivity() {
    private lateinit var btnStandarad: Button

    private lateinit var btnSingleTop: Button

    private lateinit var btnSingleTask: Button

    private lateinit var btnSingleInstance: Button

    private lateinit var tvActivity: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,this.toString())
        setContentView(R.layout.activity_launch_model)
        btnStandarad = findViewById(R.id.btn_standard)
        btnSingleTop = findViewById(R.id.btn_singleTop)
        btnSingleTask= findViewById(R.id.btn_singleTask)
        btnSingleInstance=findViewById(R.id.btn_singleInstance)
        tvActivity = findViewById(R.id.tv_activity)
        btnStandarad.setOnClickListener {
            val intent = Intent(this, StandardActivity::class.java)
            startActivity(intent)
        }
        btnSingleTop.setOnClickListener {
            val intent = Intent(this, SingleTopActivity::class.java)
            startActivity(intent)
        }
        btnSingleTask.setOnClickListener {
            val intent = Intent(this,SingleTaskActivity::class.java)
            startActivity(intent)
        }
        btnSingleInstance.setOnClickListener {
            val intent = Intent(this,SingleInstanceActivity::class.java)
            startActivity(intent)
        }
        tvActivity.text = "$this,taskId $taskId"
    }

    companion object{
        private val TAG  = this.javaClass.simpleName
    }
}