package com.example.billage.Login

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.billage.Modal.ModalBottomSheet
import com.example.billage.Modal.ModalBottomSheet.Companion.TAG
import com.example.billage.Modal.ModalBottomSheetAdapter
import com.example.billage.Modal.ModalBottomSheetItem
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginStudentInformBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text
import java.lang.reflect.Array

// Fragment Index 3

class LoginStudentInformFragment : Fragment() {

    lateinit var binding : FragmentLoginStudentInformBinding
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 소속 단과 대학 버튼
        val btnOpenCollegeBottomSheet = binding.editTextCollege
        val btnOpenMajorBottomSheet = binding.editTextMajor
        // Toolbar 설정
        val toolbar: Toolbar = binding.toolbarStudentInform

        toolbar.setTitle(R.string.toolbar_student_inform)
        toolbar.setNavigationIcon(R.drawable.icon_back_button)
        // Toolbar 뒤로가기
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // 뒤로가기
        }

        modalBottomSheet(btnOpenCollegeBottomSheet, collegeList, 1)
        modalBottomSheet(btnOpenMajorBottomSheet, majorList, 2)
    }

    // Modal창 여는 함수
    fun modalBottomSheet(btn : EditText, list: MutableList<ModalBottomSheetItem>, url: Int){
        val adapter = ModalBottomSheetAdapter()
        val bottomSheetFragment = ModalBottomSheet(adapter)
        val textViewSelect = view?.findViewById<TextView>(R.id.textViewSelect)
        adapter.setItem(list)



        val sfm = (activity as LoginActivity).supportFragmentManager
        btn.setOnClickListener {
            bottomSheetFragment.show(sfm, TAG)
        }
    }

//    // EditText 비활성화
//    fun editTextUnclickable(){
//        binding.editTextMajor
//            .setclickab
//    }

}