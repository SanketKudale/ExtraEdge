package com.sanket.extraedge.model

import com.google.gson.annotations.SerializedName

data class Rocket(

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
    @SerializedName("stages") var stages: Double? = null,
    @SerializedName("boosters") var boosters: Double? = null,
    @SerializedName("cost_per_launch") var costPerLaunch: Double? = null,
    @SerializedName("success_rate_pct") var successRatePct: Double? = null,
    @SerializedName("first_flight") var firstFlight: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("company") var company: String? = null,
    @SerializedName("wikipedia") var wikipedia: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("id") var id: String? = null

)

data class Height(

    @SerializedName("meters") var meters: Double? = null,
    @SerializedName("feet") var feet: Double? = null

)

data class Diameter(

    @SerializedName("meters") var meters: Double? = null,
    @SerializedName("feet") var feet: Double? = null

)


data class Mass(

    @SerializedName("kg") var kg: Double? = null,
    @SerializedName("lb") var lb: Double? = null

)

data class ThrustSeaLevel(

    @SerializedName("kN") var kN: Double? = null,
    @SerializedName("lbf") var lbf: Double? = null

)

data class ThrustVacuum(

    @SerializedName("kN") var kN: Double? = null,
    @SerializedName("lbf") var lbf: Double? = null

)

data class FirstStage(

    @SerializedName("thrust_sea_level") var thrustSeaLevel: ThrustSeaLevel? = ThrustSeaLevel(),
    @SerializedName("thrust_vacuum") var thrustVacuum: ThrustVacuum? = ThrustVacuum(),
    @SerializedName("reusable") var reusable: Boolean? = null,
    @SerializedName("engines") var engines: Double? = null,
    @SerializedName("fuel_amount_tons") var fuelAmountTons: Double? = null,
    @SerializedName("burn_time_sec") var burnTimeSec: Double? = null

)

data class Thrust(

    @SerializedName("kN") var kN: Double? = null,
    @SerializedName("lbf") var lbf: Double? = null

)

data class CompositeFairing(

    @SerializedName("height") var height: Height? = Height(),
    @SerializedName("diameter") var diameter: Diameter? = Diameter()

)

data class Payloads(

    @SerializedName("composite_fairing") var compositeFairing: CompositeFairing? = CompositeFairing(),
    @SerializedName("option_1") var option1: String? = null

)

data class SecondStage(

    @SerializedName("thrust") var thrust: Thrust? = Thrust(),
    @SerializedName("payloads") var payloads: Payloads? = Payloads(),
    @SerializedName("reusable") var reusable: Boolean? = null,
    @SerializedName("engines") var engines: Double? = null,
    @SerializedName("fuel_amount_tons") var fuelAmountTons: Double? = null,
    @SerializedName("burn_time_sec") var burnTimeSec: Double? = null

)

data class Isp(

    @SerializedName("sea_level") var seaLevel: Double? = null,
    @SerializedName("vacuum") var vacuum: Double? = null

)

data class Engines(

    @SerializedName("isp") var isp: Isp? = Isp(),
    @SerializedName("thrust_sea_level") var thrustSeaLevel: ThrustSeaLevel? = ThrustSeaLevel(),
    @SerializedName("thrust_vacuum") var thrustVacuum: ThrustVacuum? = ThrustVacuum(),
    @SerializedName("number") var number: Double? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("version") var version: String? = null,
    @SerializedName("layout") var layout: String? = null,
    @SerializedName("engine_loss_max") var engineLossMax: Double? = null,
    @SerializedName("propellant_1") var propellant1: String? = null,
    @SerializedName("propellant_2") var propellant2: String? = null,
    @SerializedName("thrust_to_weight") var thrustToWeight: Double? = null

)

data class LandingLegs(

    @SerializedName("number") var number: Double? = null,
    @SerializedName("material") var material: String? = null

)

data class PayloadWeights(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("kg") var kg: Double? = null,
    @SerializedName("lb") var lb: Double? = null

)