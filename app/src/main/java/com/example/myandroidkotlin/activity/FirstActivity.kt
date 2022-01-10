package com.example.myandroidkotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.parcelable.Person
import com.example.myandroidkotlin.parcelable.Student

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        findViewById<Button>(R.id.btn_second).setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val list = mutableListOf(Person("jj",10),Person("jx",12))
            intent.putExtra("test", Student("asd",10,list))
            startActivity(intent)
        }
    }
}