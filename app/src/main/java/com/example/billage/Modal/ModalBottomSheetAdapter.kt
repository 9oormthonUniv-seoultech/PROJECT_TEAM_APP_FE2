package com.example.billage.Modal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.R

class ModalBottomSheetAdapter : RecyclerView.Adapter<ModalBottomSheetAdapter.Holder>() {
    private var itemList : MutableList<ModalBottomSheetItem> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModalBottomSheetAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_view_bottom_sheet_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: ModalBottomSheetAdapter.Holder, position: Int) {
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

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view){
        fun bind(item: ModalBottomSheetItem){
            view.findViewById<TextView>(R.id.textViewBottomSheetItem).text = item.name
        }
    }

}