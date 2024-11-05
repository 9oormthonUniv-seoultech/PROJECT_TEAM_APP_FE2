package com.example.billage.Admin.ClassRoomStatus.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.Admin.ClassRoomStatus.DateItem
import com.example.billage.R
import com.example.billage.databinding.ItemDateBinding

class DateAdapter(private val dates: List<DateItem>) : RecyclerView.Adapter<DateAdapter.ViewHolder>() {
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
            ItemDateBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = dates[position].date.toString()
        holder.day.text = dates[position].day.toString()
    }

    override fun getItemCount() = dates.size

    inner class ViewHolder(val binding: ItemDateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val date = binding.textViewDate
        val day = binding.textViewDay

        init {
            binding.root.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
                true
            }
        }
    }

}