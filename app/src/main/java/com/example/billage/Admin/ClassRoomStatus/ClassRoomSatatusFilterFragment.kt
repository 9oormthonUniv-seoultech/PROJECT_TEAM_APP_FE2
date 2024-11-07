package com.example.billage.Admin.ClassRoomStatus

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.Admin.ClassRoomStatus.Adapter.ClassRoomFilterAdapter
import com.example.billage.Admin.ClassRoomStatus.Adapter.DateAdapter
import com.example.billage.AdminActivity
import com.example.billage.MainUtil.setStatusBarTransparent
import com.example.billage.R
import com.example.billage.databinding.FragmentClassRoomSatatusFilterBinding

class ClassRoomSatatusFilterFragment : Fragment() {

    lateinit var binding: FragmentClassRoomSatatusFilterBinding
    lateinit var adminActivity: AdminActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var floor = 1

        binding = FragmentClassRoomSatatusFilterBinding.inflate(layoutInflater)
        adminActivity = activity as AdminActivity

        binding.run {
            buttonMinus.setOnClickListener {
                if(floor != 1) {
                    floor -= 1
                }
            }

            buttonPlus.setOnClickListener {
                floor += 1
            }
        }

        return binding.root
    }

    fun initView() {
        binding.run {
            adminActivity.setStatusBarTransparent()

            toolbar.buttonBack.setOnClickListener {
                fragmentManager?.popBackStack()
            }


            var buildingItem = listOf<BuildingItem>()
            val dateAdapter = ClassRoomFilterAdapter(buildingItem)

            recyclerViewBuilding.run {
                adapter = dateAdapter

                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

}

data class BuildingItem(val num: Int, val building: String)