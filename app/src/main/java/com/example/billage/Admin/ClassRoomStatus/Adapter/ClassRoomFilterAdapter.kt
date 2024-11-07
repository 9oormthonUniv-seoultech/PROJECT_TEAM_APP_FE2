package com.example.billage.Admin.ClassRoomStatus.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.Admin.ClassRoomStatus.BuildingItem
import com.example.billage.databinding.LayoutSelectBuildingBinding

class ClassRoomFilterAdapter(private val buildings: List<BuildingItem>) : RecyclerView.Adapter<ClassRoomFilterAdapter.ViewHolder>() {

    private var onItemClickListener: ((Int) -> Unit)? = null
    private var context: Context? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int) {}
    }

    var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val binding =
            LayoutSelectBuildingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.num.text = buildings[position].num.toString()
        holder.name.text = buildings[position].building.toString()
    }

    override fun getItemCount() = buildings.size

    inner class ViewHolder(val binding: LayoutSelectBuildingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val num = binding.textViewBuildingNumber
        val name = binding.textViewBuildingName

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
                true
            }
        }
    }
}