package com.example.billage.User

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.billage.R
import com.example.billage.User.Building.BuildingAdapter
import com.example.billage.User.Building.BuildingData
import com.example.billage.User.Calender.CalenderAdpater
import com.example.billage.User.Calender.CalenderData
import com.example.billage.databinding.FragmentUserMapBinding

// Fragment Index 0

class UserMapFragment : Fragment() {

    private lateinit var binding : FragmentUserMapBinding
    private lateinit var recyclerViewCalender: RecyclerView
    private lateinit var calenderAdapter: CalenderAdpater
    private lateinit var recyclerViewBuilding: RecyclerView
    private lateinit var buildingAdapter: BuildingAdapter

    // 날짜 dummy 데이터
    val calenderList = listOf(
        CalenderData("11월4일", "월요일"),
        CalenderData("11월5일", "화요일"),
        CalenderData("11월6일", "수요일"),
        CalenderData("11월7일", "목요일"),
        CalenderData("11월8일", "금요일"),
        CalenderData("11월9일", "토요일"),
        CalenderData("11월10일", "일요일"),
    )

    // 건물 dummy 데이터
    val buildingList = listOf(
        BuildingData("01", "대학본부"),
        BuildingData("02", "다빈치관"),
        BuildingData("03", "창학관"),
        BuildingData("04", "어의관"),
        BuildingData("05", "국제관"),
        BuildingData("06", "상상관"),
        BuildingData("07", "상상관"),
        BuildingData("08", "상상관"),
        BuildingData("09", "상상관"),
        BuildingData("10", "상상관"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserMapBinding.inflate(inflater, container, false)

        // Calender RecyclerView 초기화 및 Adapter 설정
        recyclerViewCalender = binding.recyclerViewSelectDate
        recyclerViewCalender.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        calenderAdapter = CalenderAdpater(calenderList)
        recyclerViewCalender.adapter = calenderAdapter

        // Building RecyclerView 초기화 및 Adapter 설정
        recyclerViewBuilding = binding.recyclerViewSelectBuilding
        recyclerViewBuilding.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        buildingAdapter = BuildingAdapter(buildingList)
        recyclerViewBuilding.adapter = buildingAdapter

        // 희망인원 카운터
        counter()

        return binding.root
    }

    // 희망 인원 COUNTER BUTTON
    private fun counter(){
        val count = binding.textViewPeopleCount
        binding.imageButtonMinus.setOnClickListener {
            var number = count.text.toString().toInt()
            if (number > 0){
                number -= 1
                count.text = number.toString()
            }
        }
        binding.imageButtonPlus.setOnClickListener {
            var number = count.text.toString().toInt()
            number += 1
            count.text = number.toString()
        }
    }
}