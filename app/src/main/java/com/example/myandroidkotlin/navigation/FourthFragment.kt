package com.example.myandroidkotlin.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myandroidkotlin.databinding.FragmentSecondBinding

/**
 * ClassName: FourthFragment<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/17 15:02<br/>
 *
 * @author yckj1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class FourthFragment: Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        //通过safe args完成参数接收
        //通过safe args完成参数接收
        val bundle = arguments
        if (bundle != null) {
            val userName = arguments?.let { MainFragmentArgs.fromBundle(it).userName }
            val age = arguments?.let { MainFragmentArgs.fromBundle(it).age }
            binding.text.text = "message$userName$age"
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }


}