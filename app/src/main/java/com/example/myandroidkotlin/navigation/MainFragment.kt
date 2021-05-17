package com.example.myandroidkotlin.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.FragmentMainBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.btnToSecondFragment.setOnClickListener {
            //两种方法均可
            val bundle =
                MainFragmentArgs.Builder().setUserName("Michael").setAge(30).build().toBundle()
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_secondFragment,bundle)
        }

        binding.btnToThirdFragment.setOnClickListener {
            //两种方法均可
            val bundle =
                MainFragmentArgs.Builder().setUserName("Nick").setAge(28).build().toBundle()
            findNavController(this).navigate(R.id.action_mainFragment_to_thirdFragment,bundle)
        }

        binding.btnToFourthFragment.setOnClickListener {
            //两种方法均可
            val bundle =
                MainFragmentArgs.Builder().setUserName("York").setAge(24).build().toBundle()
            Navigation.findNavController(it).navigate(R.id.action_mainFragment_to_thirdFragment,bundle)
        }

        //Observe the result to be set by Fragment B in the stateHandle of the currentBackStackEntry
        val currentBackStackEntry = findNavController(this).currentBackStackEntry
        val savedStateHandle = currentBackStackEntry?.savedStateHandle
        savedStateHandle?.getLiveData<String>(RESULT_FROM_FRAGMENT)
            ?.observe(currentBackStackEntry, Observer { result ->
                binding.tvResult.text = result
            })
        return binding.root
    }

    companion object {
        const val RESULT_FROM_FRAGMENT = "RESULT_FROM_FRAGMENT"
    }

}