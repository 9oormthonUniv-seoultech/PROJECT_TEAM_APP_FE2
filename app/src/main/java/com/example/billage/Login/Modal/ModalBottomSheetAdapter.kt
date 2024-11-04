package com.example.billage.Login.Modal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.R
import com.example.billage.databinding.LayoutListViewBottomSheetItemBinding

class ModalBottomSheetAdapter(private val listener: OnItemClickListener) : RecyclerView.Adapter<ModalBottomSheetAdapter.Holder>() {
    private var itemList : MutableList<ModalBottomSheetItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder {
        val view = Holder(LayoutListViewBottomSheetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        return view
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun setItem(items: MutableList<ModalBottomSheetItem>){
        this.itemList = items
        notifyDataSetChanged()
    }

    inner class Holder(var binding: LayoutListViewBottomSheetItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: ModalBottomSheetItem){
            binding.textViewBottomSheetItem.text = item.name
            binding.root.setOnClickListener {
                // RecyclerView 아이템 클릭 시 이벤트 발생
                listener.onItemClick(item)
            }
        }
    }

    // 클릭 이벤트를 전달하기위한 인터페이스
    interface OnItemClickListener {
        fun onItemClick(item: ModalBottomSheetItem)
    }

}