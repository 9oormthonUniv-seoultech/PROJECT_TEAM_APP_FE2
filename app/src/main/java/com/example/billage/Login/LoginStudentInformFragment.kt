package com.example.billage.Login

import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.billage.Login.Modal.ModalBottomSheet
import com.example.billage.Login.Modal.ModalBottomSheet.Companion.TAG
import com.example.billage.Login.Modal.ModalBottomSheetAdapter
import com.example.billage.Login.Modal.ModalBottomSheetItem
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginStudentInformBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text
import java.lang.reflect.Array

// Fragment Index 3

class LoginStudentInformFragment : Fragment(), ModalBottomSheetAdapter.OnItemClickListener {

    lateinit var adapter : ModalBottomSheetAdapter
    lateinit var binding : FragmentLoginStudentInformBinding
    lateinit var bottomSheet : ModalBottomSheet
    var isCollegeSelected = false
    var isMajorSelected = false
    var collegeForButton = false
    var majorForButton = false

    // 학과 전공 dummy data
    val collegeList = mutableListOf(
        ModalBottomSheetItem("공과대학"),
        ModalBottomSheetItem("정보통신대학"),
        ModalBottomSheetItem("에너지바이오대학"),
        ModalBottomSheetItem("조형대학"),
        ModalBottomSheetItem("인문사회대학")
    )
    val majorList = mutableListOf(
        ModalBottomSheetItem("시각디자인학과"),
        ModalBottomSheetItem("산업디자인학과"),
        ModalBottomSheetItem("조형예술학과"),
        ModalBottomSheetItem("도예학과"),
        ModalBottomSheetItem("금속공예디자인학과")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginStudentInformBinding.inflate(inflater, container, false)

        binding.buttonStudentInformNext.setOnClickListener {
            (activity as LoginActivity).changeFragment(4)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ModalBottomSheetAdapter(this)
        bottomSheet = ModalBottomSheet(adapter, "")

        // Toolbar 설정
        val navigationBtn : ImageButton = binding.imageButtonNavigation
        // Toolbar 뒤로가기
        navigationBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // 뒤로가기
        }

        // 소속 단과 대학 버튼
        val btnOpenCollegeBottomSheet = binding.textViewSelectedCollege
        val btnOpenMajorBottomSheet = binding.textViewSelectedMajor

        btnOpenCollegeBottomSheet.setOnClickListener {
            isCollegeSelected = true
            modalBottomSheet(collegeList, getString(R.string.textview_select_1), bottomSheet)
        }
        btnOpenMajorBottomSheet.setOnClickListener {
            isMajorSelected = true
            modalBottomSheet(majorList, getString(R.string.textview_select_2), bottomSheet)

        }
    }

    // Modal창 여는 함수
    fun modalBottomSheet(list: MutableList<ModalBottomSheetItem>, miniTitle: String, bottomsheet: ModalBottomSheet){
        if (!bottomsheet.isAdded) {
            bottomsheet.adapter.setItem(list)
            bottomsheet.miniTitle = miniTitle
            // item 클릭 시 TextView 업데이트
            // onItemClick(list, btn)

            val sfm = (activity as LoginActivity).supportFragmentManager
            bottomsheet.show(sfm, ModalBottomSheet.TAG)
        }
    }

    override fun onItemClick(item: ModalBottomSheetItem) {
        if (isCollegeSelected){
            binding.textViewSelectedCollege.text = item.name
            isCollegeSelected = false
            collegeForButton = true
        }
        else {
            binding.textViewSelectedMajor.text = item.name
            isMajorSelected = false
            majorForButton = true
        }
        if (isAdded){
            bottomSheet.dismiss()
        }

        checkSelections()
    }

    // Colleg & Major가 선택이 됐을 경우에 '다음으로' 버튼 활성화
    private fun checkSelections(){
        binding.buttonStudentInformNext.isEnabled = collegeForButton&&majorForButton
    }

//    // EditText 비활성화
//    fun editTextUnclickable(){
//        binding.editTextMajor
//            .setclickab
//    }

}