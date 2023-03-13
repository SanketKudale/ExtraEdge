package com.sanket.extraedge.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.extraedge.model.Rocket
import com.sanket.extraedge.model.RocketDetails
import com.sanket.extraedge.retrofit.RetroRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RocketDetailsViewModel @Inject constructor(private val repo: RetroRepo) : ViewModel() {
    var liveDataList: MutableLiveData<RocketDetails> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<RocketDetails> {
        return liveDataList
    }

    fun loadData(rocketId: String) {
        repo.getRocketDetails(rocketId, liveDataList)
    }
}