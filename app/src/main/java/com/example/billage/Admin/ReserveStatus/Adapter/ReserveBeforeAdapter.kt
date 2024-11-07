package com.example.billage.Admin.ReserveStatus.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.Admin.ReserveStatus.ReserveItem
import com.example.billage.databinding.ItemReserveManagementBinding

class ReserveBeforeAdapter(private val reserves: List<ReserveItem>) : RecyclerView.Adapter<ReserveBeforeAdapter.ViewHolder>() {

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
            ItemReserveManagementBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.setText(reserves[position].date.toString())
        holder.time.setText(reserves[position].building.toString())
        holder.building.setText(reserves[position].building.toString())
        holder.numOfPeople.setText(reserves[position].numOfPeople.toString())
        holder.classRoom.setText(reserves[position].classRoom.toString())
        holder.buttonDatail.text = "상세 보기"
    }

    override fun getItemCount() = reserves.size

    inner class ViewHolder(val binding: ItemReserveManagementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val date = binding.editTextDate
        val time = binding.editTextTime
        val building = binding.editTextBuilding
        val numOfPeople = binding.editTextPeople
        val classRoom = binding.editTextClassRoom
        val buttonDatail = binding.buttonManageReserve

        init {
            binding.buttonManageReserve.setOnClickListener {
                itemClickListener?.onItemClick(adapterPosition)
                true
            }
        }
    }
}