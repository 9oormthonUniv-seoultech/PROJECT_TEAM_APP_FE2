package com.example.billage.Admin.ReserveStatus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billage.R

class ReserveAcceptFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reserve_accept, container, false)
    }
}

data class ReserveItem(val date: String, val time: String, val building: String, val classRoom: String, val numOfPeople: Int)