package com.example.myapplication.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Senator

class ListingViewModel : ViewModel() {


    var senatorsList = MutableLiveData<Array<Senator>>()

    init {
        senatorsList.value = emptyArray()
    }


}