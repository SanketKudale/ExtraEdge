package com.sanket.extraedge.retrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sanket.extraedge.model.Rocket
import com.sanket.extraedge.model.RocketDetails
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetroRepo @Inject constructor(private val apiInterface: ApiInterface) {
    fun getRockets(liveDataList: MutableLiveData<ArrayList<Rocket>>){
        val call: Call<ArrayList<Rocket>> = apiInterface.getRockets()
        call.enqueue(object : Callback<ArrayList<Rocket>>{
            override fun onResponse(call: Call<ArrayList<Rocket>>, response: Response<ArrayList<Rocket>>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<ArrayList<Rocket>>, t: Throwable) {
                Log.e("retroR","${t.cause}")
                liveDataList.postValue(null)
            }
        })
    }

    fun getRocketDetails(rocketId: String, liveDataList: MutableLiveData<RocketDetails>){
        val call: Call<RocketDetails> = apiInterface.getRocketDetails(rocketId)
        call.enqueue(object : Callback<RocketDetails>{
            override fun onResponse(call: Call<RocketDetails>, response: Response<RocketDetails>) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<RocketDetails>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }
}