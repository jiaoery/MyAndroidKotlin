package com.example.myandroidkotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityTestSpreadViewBinding

class TestSpreadViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTestSpreadViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_test_spread_view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

   fun onClick(view:View){
        when(view.id){
            R.id.button3->binding.spreadView.setSpreadStatus(true)
                R.id.button4->binding.spreadView.setSpreadStatus(false)
        }
    }
}