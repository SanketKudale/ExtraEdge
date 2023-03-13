package com.sanket.extraedge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.sanket.extraedge.R
import com.sanket.extraedge.adapter.RocketAdapter
import com.sanket.extraedge.databinding.ActivityMainBinding
import com.sanket.extraedge.viewmodel.RocketViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RocketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapter = RocketAdapter()

        initViewModel()
    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this)[RocketViewModel::class.java]

        viewModel.getLiveDataObserver().observe(this, Observer {
            Log.e("response","$it")
            if (it != null)
            {
                binding.rvRockets.layoutManager = GridLayoutManager(this,2)
                adapter.setRockets(it)
                binding.adapter = adapter
            }
            else{
                Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadData()
    }
}