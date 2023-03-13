package com.sanket.extraedge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.extraedge.model.Rocket
import com.sanket.extraedge.databinding.ItemRocketBinding

class RocketAdapter() : RecyclerView.Adapter<RocketAdapter.RocketViewHolder>() {

    private lateinit var binding: ItemRocketBinding
    private var rockets: ArrayList<Rocket> = ArrayList()

    var listener: RocketClick? = null

    fun setRockets(context: Context, list: ArrayList<Rocket>){
        listener = context as RocketClick
        rockets = list
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RocketViewHolder {
        binding = ItemRocketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RocketViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RocketViewHolder, position: Int) {
        val rocket = rockets[position]
        holder.bind(rocket)
        binding.cvRocket.setOnClickListener { listener!!.onRocketClick(rocket.id.toString()) }
    }

    override fun getItemCount(): Int {
        return if (rockets.isEmpty()){
            0
        }
        else{
            rockets.size
        }
    }

    class RocketViewHolder(private val binding: ItemRocketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val slider = binding.slider
        fun bind(rocket: Rocket) {
            binding.rocket = rocket

            val imageList = ArrayList<String>()
            imageList.addAll(rocket.flickrImages)

            val sliderAdapter = SliderAdapter(imageList)

            slider.isAutoCycle = true
            slider.setSliderAdapter(sliderAdapter)

        }
    }

    interface RocketClick{
        fun onRocketClick(rocketId: String)
    }

}