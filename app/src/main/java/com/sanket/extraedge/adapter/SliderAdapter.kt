package com.sanket.extraedge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sanket.extraedge.R
import com.sanket.extraedge.di.GlideApp
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(imageUrl: ArrayList<String>) :
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {

    var sliderList: ArrayList<String> = imageUrl

    override fun getCount(): Int {
        return sliderList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderViewHolder {
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.slider_item, null)

        return SliderViewHolder(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderViewHolder?, position: Int) {

        if (viewHolder != null) {
            GlideApp.with(viewHolder.itemView).load(sliderList[position]).fitCenter()
                .into(viewHolder.imageView)
        }
    }

    class SliderViewHolder(itemView: View?) : ViewHolder(itemView) {

        var imageView: ImageView = itemView!!.findViewById(R.id.iv_slider)
    }
}