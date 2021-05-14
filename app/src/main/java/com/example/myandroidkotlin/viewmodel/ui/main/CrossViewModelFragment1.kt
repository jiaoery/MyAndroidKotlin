package com.example.myandroidkotlin.viewmodel.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myandroidkotlin.R

/**
 * ClassName: CrossViewModelFragment1<br/>
 * Description: TODO Description. <br/>
 * date: 2021/5/14 11:26<br/>
 *
 * @author YCKJ1729
 * @version V1.0.0
 * @since JDK 1.8
 */
class CrossViewModelFragment1: Fragment() {

    companion object {
        fun newInstance() = CrossViewModelFragment1()
    }

    private val model: CrossViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.cross_view_model_fragment1, container, false)
        val message:TextView = view.findViewById(R.id.message)
        model.selected.observe(viewLifecycleOwner, { messages->
            message.text = messages
        })
        return view
    }


}