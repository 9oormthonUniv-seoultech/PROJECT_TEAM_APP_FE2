package com.example.billage.User.Building

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.User.Calender.CalenderData
import com.example.billage.databinding.LayoutSelectBuildingBinding
import com.example.billage.databinding.LayoutSelectDateBinding

class BuildingAdapter(private val itemList: List<BuildingData>) : RecyclerView.Adapter<BuildingAdapter.BuildingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuildingViewHolder {
        val view = BuildingViewHolder(LayoutSelectBuildingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return view
    }

    override fun onBindViewHolder(holder: BuildingViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class BuildingViewHolder(var binding: LayoutSelectBuildingBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: BuildingData){
            binding.textViewBuildingNumber.text = item.number
            binding.textViewBuildingName.text = item.name
        }
    }
}