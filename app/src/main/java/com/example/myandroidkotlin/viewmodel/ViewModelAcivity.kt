package com.example.myandroidkotlin.viewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myandroidkotlin.R

/**
 * ClassName: ViewModelAcivity<br/>
 * Description: ViewModel Activity
 * date: 2021/5/13 14:33<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class ViewModelAcivity : AppCompatActivity() {
    private lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)
        textView = findViewById(R.id.textView)
        val model: MyViewModel by viewModels()
        model.setOnTimeChangedListener(object :MyViewModel.OnTimeChangedListener{
            override fun onTimeChanged(second: Int) {
                runOnUiThread { textView.text = "计时器：$second"}

            }
        })

        model.startTimeing()

        model.getUsers().observe(this, Observer {
            // update UI
        })

    }

}