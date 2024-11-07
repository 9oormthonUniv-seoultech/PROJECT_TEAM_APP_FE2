package com.example.billage.Admin.Reserve

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billage.Admin.Reserve.BottomSheet.EndTimeBottomSheetFragment
import com.example.billage.Admin.Reserve.BottomSheet.StartTimeBottomSheetFragment
import com.example.billage.AdminActivity
import com.example.billage.databinding.FragmentReserveDefaultBinding

class ReserveDefaultFragment : Fragment(), StartTimeBottomSheetFragment.OnTimeSelectedListener, EndTimeBottomSheetFragment.OnTimeSelectedListener {

    lateinit var binding: FragmentReserveDefaultBinding
    lateinit var adminActivity: AdminActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentReserveDefaultBinding.inflate(layoutInflater)
        adminActivity = activity as AdminActivity

        binding.run {
            buttonSelectStartTime.setOnClickListener {
                val timePickerFragment = StartTimeBottomSheetFragment()
                timePickerFragment.show(adminActivity.supportFragmentManager, timePickerFragment.tag)
            }

            buttonSelectEndTime.setOnClickListener {
                val timePickerFragment = EndTimeBottomSheetFragment()
                timePickerFragment.show(adminActivity.supportFragmentManager, timePickerFragment.tag)
            }
        }

        return binding.root
    }

    override fun onTimeStartSelected(ampm: String, hour: Int, minute: Int) {
        binding.textViewStartHour.text = hour.toString()
    }

    override fun onTimeEndSelected(ampm: String, hour: Int, minute: Int) {
        binding.textViewEndHour.text = hour.toString()
    }
}