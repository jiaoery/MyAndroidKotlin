package com.example.myandroidkotlin.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myandroidkotlin.databinding.FragmentSecondBinding
import com.example.myandroidkotlin.navigation.MainFragmentArgs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    private lateinit var binding:FragmentSecondBinding

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