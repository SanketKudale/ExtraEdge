package com.sanket.extraedge.retrofit

import com.sanket.extraedge.model.Rocket
import com.sanket.extraedge.model.RocketDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("rockets")
    fun getRockets() : Call<ArrayList<Rocket>>

    @GET("rockets/")
    fun getRocketDetails(@Path("id") rocketId: String) : Call<RocketDetails>

}