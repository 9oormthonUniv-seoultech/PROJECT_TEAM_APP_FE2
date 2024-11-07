package com.example.billage.Admin.Reserve.BottomSheet

// TimePickerBottomSheetFragment.kt
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billage.databinding.BottomsheetTimeBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class EndTimeBottomSheetFragment : BottomSheetDialogFragment() {

    lateinit var binding: BottomsheetTimeBinding

    interface OnTimeSelectedListener {
        fun onTimeEndSelected(ampm: String, hour: Int, minute: Int)
    }

    private var onTimeSelectedListener: OnTimeSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTimeSelectedListener) {
            onTimeSelectedListener = context
        } else {
            throw RuntimeException("$context must implement OnTimeSelectedListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomsheetTimeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            // 오전/오후 설정
            spinnerAmPm.minValue = 0
            spinnerAmPm.maxValue = 1
            spinnerAmPm.displayedValues = arrayOf("오전", "오후")

            // 시간 설정 (1 ~ 12)
            spinnerHour.minValue = 1
            spinnerHour.maxValue = 12
            spinnerHour.value = 10 // 기본값 설정

            // 분 설정
            spinnerMinute.minValue = 0
            spinnerMinute.maxValue = 0
            spinnerMinute.displayedValues = arrayOf("00")
            spinnerMinute.value = 0 // 기본값 설정
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        binding.run {
            // BottomSheet가 닫힐 때 선택된 값을 전달합니다.
            val ampm = spinnerAmPm.displayedValues[spinnerAmPm.value]
            val hour = spinnerHour.value
            val minute = spinnerMinute.displayedValues[spinnerMinute.value].toInt()

            onTimeSelectedListener?.onTimeEndSelected(ampm, hour, minute)
        }
    }
}
