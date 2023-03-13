package com.sanket.extraedge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.extraedge.model.Rocket
import com.sanket.extraedge.retrofit.RetroRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketViewModel @Inject constructor(private val repo: RetroRepo): ViewModel() {
    var liveDataList: MutableLiveData<ArrayList<Rocket>> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<ArrayList<Rocket>>{
        return liveDataList
    }

    fun loadData(){
        repo.getRockets(liveDataList)
    }
}