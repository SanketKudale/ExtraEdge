package com.sanket.extraedge.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.gk.emon.lovelyLoading.LoadingPopup
import com.sanket.extraedge.R
import com.sanket.extraedge.adapter.RocketAdapter
import com.sanket.extraedge.databinding.ActivityMainBinding
import com.sanket.extraedge.db.RocketEntity
import com.sanket.extraedge.db.RoomRepo
import com.sanket.extraedge.viewmodel.RocketDetailsViewModel
import com.sanket.extraedge.viewmodel.RocketViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), RocketAdapter.RocketClick {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RocketAdapter

    @Inject
    lateinit var repo: RoomRepo

    @Inject
    lateinit var rocketEntity: RocketEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = RocketAdapter()

        LoadingPopup.getInstance(this)
            .defaultLovelyLoading()
            .setBackgroundColor(android.R.color.darker_gray)
            .setBackgroundOpacity(90)/*Int between 0-100*/
            .build()

        LoadingPopup.showLoadingPopUp()

        initViewModel()
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this)[RocketViewModel::class.java]

        binding.rvRockets.layoutManager = GridLayoutManager(this, 2)

        if (repo.getRockets().isNotEmpty()) {
            Log.e("rocketLog", "LocalCall")
            adapter.setRockets(this@MainActivity, repo.getRockets())
            binding.adapter = adapter
            LoadingPopup.hideLoadingPopUp()
        } else {
            Log.e("rocketLog", "netCall")
            viewModel.getLiveDataObserver().observe(this) { rocketList ->
                if (rocketList != null) {
                    val listTemp = ArrayList<RocketEntity>()
                    for (item in rocketList) {
                        rocketEntity = RocketEntity(
                            id = item.id!!,
                            name = item.name,
                            country = item.country,
                            engines = item.engines?.number,
                            images = item.flickrImages,
                        )

                        repo.saveRocket(rocketEntity)
                        listTemp.add(rocketEntity)
                    }

                    adapter.setRockets(this@MainActivity, listTemp)
                    binding.adapter = adapter
                    LoadingPopup.hideLoadingPopUp()

                } else {
                    LoadingPopup.hideLoadingPopUp()
                    Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show()
                }
            }
            viewModel.loadData()
        }

    }

    override fun onRocketClick(rocketId: String) {
        startActivity(
            Intent(
                this@MainActivity,
                RocketDetailActivity::class.java
            ).putExtra("rocketId", rocketId)
        )
    }

}