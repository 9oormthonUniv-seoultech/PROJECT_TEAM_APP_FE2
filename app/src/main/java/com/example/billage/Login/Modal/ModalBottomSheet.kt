package com.example.billage.Login.Modal

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.Login.LoginActivity
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginStudentInformBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalBottomSheet(val adapter: ModalBottomSheetAdapter, var miniTitle: String) : BottomSheetDialogFragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_bottom_sheet, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBottomSheet)
        view.findViewById<TextView>(R.id.textViewSelect).text = miniTitle

        recyclerView.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    companion object{
        const val TAG = "BasicBottomModalSheet"
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme


}