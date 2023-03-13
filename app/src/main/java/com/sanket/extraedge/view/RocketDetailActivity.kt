package com.sanket.extraedge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanket.extraedge.R
import com.sanket.extraedge.adapter.SliderAdapter
import com.sanket.extraedge.databinding.ActivityRocketDetailBinding
import com.sanket.extraedge.viewmodel.RocketDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailBinding
    private lateinit var rocketId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_rocket_detail)
        rocketId = intent.getStringExtra("rocketId").toString()

        initViewModel()
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this)[RocketDetailsViewModel::class.java]

        viewModel.getLiveDataObserver().observe(this) {
            Log.e("response", "$it")
            if (it != null) {
                binding.rocket = it

                val slider = binding.slider
                val imageList = ArrayList<String>()
                imageList.addAll(it.flickrImages)

                val sliderAdapter = SliderAdapter(imageList)

                slider.isAutoCycle = true
                slider.setSliderAdapter(sliderAdapter)
            } else {
                Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.loadData(rocketId)
    }
}