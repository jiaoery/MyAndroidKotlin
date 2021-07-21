package com.example.myandroidkotlin.view

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.databinding.DataBindingUtil
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityTestDimpleViewBinding

class TestDimpleViewActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTestDimpleViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_test_dimple_view)
        //旋转动画，使用属性动画
        val rotateAnimator:ObjectAnimator = ObjectAnimator.ofFloat(binding.musicAvatar, View.ROTATION, 0f, 360f)
        rotateAnimator.duration = 6000
        rotateAnimator.repeatCount = -1
        rotateAnimator.interpolator = LinearInterpolator()
        rotateAnimator.start()
    }


    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }
}