package com.example.myandroidkotlin.viewmodel.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrossViewModel : ViewModel() {

     val selected = MutableLiveData<String>()

    fun select(item: String) {
        selected.value = item
    }
}