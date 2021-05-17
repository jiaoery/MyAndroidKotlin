package com.example.myandroidkotlin.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myandroidkotlin.databinding.FragmentSecondBinding
import com.example.myandroidkotlin.databinding.FragmentThirdBinding

/**
 * ClassName: ThirdFragment<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/17 15:02<br/>
 *
 * @author yckj1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class ThirdFragment: Fragment() {

    private lateinit var binding: FragmentThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        //通过safe args完成参数接收
        //通过safe args完成参数接收
        val bundle = arguments
        if (bundle != null) {
            val userName = arguments?.let { MainFragmentArgs.fromBundle(it).userName }
            val age = arguments?.let { MainFragmentArgs.fromBundle(it).age }
            binding.text.text = "message$userName$age"
        }
        binding.btnBack.setOnClickListener { navigateBackToFragmentA() }
        return binding.root
    }

    private fun navigateBackToFragmentA() {
        //Setting the result in the stateHandle of the previousBackStackEntry before navigating back to Fragment A
        //will allow Fragment A to access the result in the stateHandle of its currentBackStackEntry
        val savedStateHandle = findNavController().previousBackStackEntry?.savedStateHandle
        savedStateHandle?.set(MainFragment.RESULT_FROM_FRAGMENT, "result:${binding.text.text}")
        findNavController().navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }


}