package com.example.myandroidkotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.parcelable.Student

class SecondActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textview1:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textView = findViewById(R.id.textView3)
        textview1 = findViewById(R.id.textView4)
        val student = intent.getParcelableExtra("test") as Student?
        student?.let {
           textView.text = "student:name ${student.username};age ${student.age}"
            val list = it.data
            val sb = StringBuilder()
            for (i in list.indices) {
                sb.append(list.get(i).name+list.get(i).age)
            }
            textview1.text = sb.toString()
        }
    }
}