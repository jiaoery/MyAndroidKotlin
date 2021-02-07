package com.example.myandroidkotlin.lifecycle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myandroidkotlin.databinding.ActivityLifeCycleActivtyBinding

class LifeCycleActivty : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLifeCycleActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // observer activity's lifecycle
        myLocationListener =
            MyLocationListener(this@LifeCycleActivty, object : OnLocationChangedListener {
                override fun onChanged(latitude: Double, longitude: Double) {
                    TODO("Not yet implemented")
                }

            })
        lifecycle.addObserver(myLocationListener)

        binding.start.setOnClickListener {
            startService(
                Intent(
                    this@LifeCycleActivty,
                    MyService::class.java
                )
            )
        }

        binding.stop.setOnClickListener {
            stopService(
                Intent(
                    this@LifeCycleActivty,
                    MyService::class.java
                )
            )
        }
    }
}