package com.example.myandroidkotlin.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.myandroidkotlin.R

class LiveDataActivity : AppCompatActivity() {

    private val viewModel:LiveDataViewModel by viewModels()
    private lateinit var nameTextView:TextView
    private lateinit var change:Button
    private var count =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        nameTextView = findViewById(R.id.tv_msg)
        change = findViewById(R.id.btn_change)
        change.setOnClickListener{ viewModel.currentName.setValue("John Doe ${count++}")}
        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            nameTextView.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.currentName.observe(this, nameObserver)

    }
}