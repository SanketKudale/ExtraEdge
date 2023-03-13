package com.sanket.extraedge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sanket.extraedge.R
import com.sanket.extraedge.databinding.ActivityRocketDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRocketDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_rocket_detail)
    }
}