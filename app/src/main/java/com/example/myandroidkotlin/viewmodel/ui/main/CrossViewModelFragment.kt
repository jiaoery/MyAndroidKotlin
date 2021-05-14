package com.example.myandroidkotlin.viewmodel.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.myandroidkotlin.R

class CrossViewModelFragment : Fragment(),View.OnClickListener {

    companion object {
        fun newInstance() = CrossViewModelFragment()
    }

    private val model: CrossViewModel by activityViewModels()
    private var count =0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.cross_view_model_fragment, container, false)
        val btn:Button = view.findViewById(R.id.btn_message)
        btn.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        model.select("Clicked ${count++}")
    }


}