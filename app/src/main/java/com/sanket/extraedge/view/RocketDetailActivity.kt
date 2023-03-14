package com.sanket.extraedge.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gk.emon.lovelyLoading.LoadingPopup
import com.sanket.extraedge.R
import com.sanket.extraedge.adapter.SliderAdapter
import com.sanket.extraedge.databinding.ActivityRocketDetailBinding
import com.sanket.extraedge.db.RocketEntity
import com.sanket.extraedge.db.RoomRepo
import com.sanket.extraedge.model.RocketDetails
import com.sanket.extraedge.viewmodel.RocketDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RocketDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailBinding
    private lateinit var rocketId: String

    @Inject
    lateinit var repo: RoomRepo

    @Inject
    lateinit var rocketEntity: RocketEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rocket_detail)
        rocketId = intent.getStringExtra("rocketId").toString()

        LoadingPopup.getInstance(this)
            .defaultLovelyLoading()
            .setBackgroundColor(android.R.color.darker_gray)
            .setBackgroundOpacity(90)/*Int between 0-100*/
            .build()

        LoadingPopup.showLoadingPopUp()

        initViewModel()
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[RocketDetailsViewModel::class.java]
        val rocketDet = repo.getRocketDetails(rocketId)
        val imageList = ArrayList<String>()
        var wikipediaLink = ""
        if (rocketDet.detailsSet == true) {
            Log.e("rocketLog", "LocalCall")
            rocketDet.images?.let { imageList.addAll(it.toList()) }
            wikipediaLink = rocketDet.wikipedia.toString()

            val slider = binding.slider
            val sliderAdapter = SliderAdapter(imageList)
            slider.isAutoCycle = true
            slider.setSliderAdapter(sliderAdapter)
            slider.startAutoCycle()
            binding.rocket = rocketDet
            LoadingPopup.hideLoadingPopUp()
        } else {
            Log.e("rocketLog", "netCall")
            viewModel.getLiveDataObserver().observe(this) { rocketDetails ->
                rocketEntity = RocketEntity(
                    id = rocketId,
                    name = rocketDet.name,
                    country = rocketDet.country,
                    engines = rocketDet.engines,
                    images = rocketDet.images,
                    costLaunch = rocketDetails.costPerLaunch,
                    success = rocketDetails.successRatePct,
                    description = rocketDetails.description,
                    wikipedia = rocketDetails.wikipedia,
                    height = rocketDetails.height?.feet,
                    diameter = rocketDetails.diameter?.feet,
                    detailsSet = true
                )
                repo.saveRocket(rocketEntity)
                imageList.addAll(rocketDetails.flickrImages)
                wikipediaLink = rocketDetails.wikipedia.toString()

                val slider = binding.slider
                val sliderAdapter = SliderAdapter(imageList)
                slider.isAutoCycle = true
                slider.setSliderAdapter(sliderAdapter)
                slider.startAutoCycle()

                binding.rocket = rocketEntity
                LoadingPopup.hideLoadingPopUp()
            }
            viewModel.loadData(rocketId)
        }

        binding.llRocket.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(wikipediaLink)))
        }

    }
}