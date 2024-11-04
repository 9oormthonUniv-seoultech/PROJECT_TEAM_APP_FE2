package com.example.billage.User.Calender

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.databinding.LayoutSelectDateBinding

class CalenderAdpater(private val itemList: List<CalenderData>) : RecyclerView.Adapter<CalenderAdpater.CalenderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalenderViewHolder {
        val view = CalenderViewHolder(LayoutSelectDateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return view
    }

    override fun onBindViewHolder(holder: CalenderViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    inner class CalenderViewHolder(var binding: LayoutSelectDateBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: CalenderData){
            binding.textViewDate.text = item.date
            binding.textViewDay.text = item.day
        }
    }
}