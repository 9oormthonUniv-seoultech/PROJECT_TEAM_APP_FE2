package com.example.billage.Admin.ClassRoomStatus

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.billage.Admin.ClassRoomStatus.Adapter.DateAdapter
import com.example.billage.R
import com.example.billage.databinding.FragmentClassRoomStatusBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ClassRoomStatusFragment : Fragment() {

    lateinit var binding: FragmentClassRoomStatusBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentClassRoomStatusBinding.inflate(layoutInflater)

        binding.run {
            // 오늘 날짜 기준으로 앞으로 30일간의 날짜를 생성
            val dates = generateDates(30)
            val dateAdapter = DateAdapter(dates)

            recyclerViewDate.run {

                adapter = dateAdapter

                layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            }
        }

        return binding.root
    }

    private fun generateDates(days: Int): List<DateItem> {
        val dates = mutableListOf<DateItem>()
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("M월 d일", Locale.getDefault())
        val dayFormat = SimpleDateFormat("EEEE", Locale.getDefault())

        for (i in 0 until days) {
            val dateString = dateFormat.format(calendar.time)
            val dayString = dayFormat.format(calendar.time)
            dates.add(DateItem(dateString, dayString))
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }

        Log.d("빌리지", "calendar : ${dates}")
        return dates
    }
}

data class DateItem(val date: String, val day: String)