package com.example.myandroidkotlin.databinding.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.SolutionBinding
import com.example.myandroidkotlin.databinding.viewmodel.SimpleViewModelSolution

/**
 * ClassName: SolutionActivity<br/>
 * Description: TODO Description. <br/>
 * date: 2021/6/10 16:11<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class SolutionActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel:SimpleViewModelSolution by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: SolutionBinding =
            DataBindingUtil.setContentView(this, R.layout.solution)

        binding.lifecycleOwner = this  // use Fragment.viewLifecycleOwner for fragments

        binding.viewmodel = viewModel
    }
}