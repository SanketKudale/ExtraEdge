package com.sanket.extraedge.model

import com.google.gson.annotations.SerializedName

data class RocketDetails(

    @SerializedName("height") var height: Height? = Height(),
    @SerializedName("diameter") var diameter: Diameter? = Diameter(),
    @SerializedName("mass") var mass: Mass? = Mass(),
    @SerializedName("first_stage") var firstStage: FirstStage? = FirstStage(),
    @SerializedName("second_stage") var secondStage: SecondStage? = SecondStage(),
    @SerializedName("engines") var engines: Engines? = Engines(),
    @SerializedName("landing_legs") var landingLegs: LandingLegs? = LandingLegs(),
    @SerializedName("payload_weights") var payloadWeights: ArrayList<PayloadWeights> = arrayListOf(),
    @SerializedName("flickr_images") var flickrImages: ArrayList<String> = arrayListOf(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("active") var active: Boolean? = null,
    @SerializedName("stages") var stages: Int? = null,
    @SerializedName("boosters") var boosters: Int? = null,
    @SerializedName("cost_per_launch") var costPerLaunch: Int? = null,
    @SerializedName("success_rate_pct") var successRatePct: Int? = null,
    @SerializedName("first_flight") var firstFlight: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("company") var company: String? = null,
    @SerializedName("wikipedia") var wikipedia: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("id") var id: String? = null

)