package com.example.lovecalculatormvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
//import com.example.lovecalculator.remote.LoveModel
//import com.example.lovecalculator.repository.Repository
import com.example.lovecalculatormvvm.remote.LoveModel
import com.example.lovecalculatormvvm.repository.Repository

class LoveViewModel : ViewModel() {

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return Repository().getLove(firstName, secondName)
    }
}