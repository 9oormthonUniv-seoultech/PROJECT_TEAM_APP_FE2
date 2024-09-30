package com.example.billage.Login

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.KeyEvent
import android.view.KeyEvent.*
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginIdPwBinding

// Fragment Index 1

class LoginIdPwFragment : Fragment() {
    private var _binding : FragmentLoginIdPwBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // toggleEye()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginIdPwBinding.inflate(inflater, container, false)
        val view = binding.root
        isStudentIdCheck()
        // 다음으로 버튼을 누를 경우 LoginPwFragment로 이동
        binding.buttonLoginNext.setOnClickListener {
            (activity as LoginActivity).changeFragment(2)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Toolbar 설정
        val navigationBtn : ImageButton = binding.imageButtonNavigation
        // Toolbar 뒤로가기
        navigationBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // 뒤로가기
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // 학번 중복 체크
    private fun isStudentIdCheck(){
        val checkImage : ImageView = binding.imageViewStudentIdCheck
        val editTextStudentId = binding.editTextStudentId
        editTextStudentId.setOnKeyListener{ view, keyCode, event ->
            if (keyCode == KEYCODE_ENTER && event.action == ACTION_UP){
                val studentId = editTextStudentId.text.toString()
                if (studentId == "19101563"){
                    checkImage.visibility = View.VISIBLE
                }
                else{
                    checkImage.visibility = View.INVISIBLE
                }
                true
            }
            else{
                false
            }
        }
    }

//    private fun editTextButtonListener(){
//        // EditText에서 엔터키 누르면 버튼 눌리게하는 함
//        val btnNext = binding.buttonLoginNext
//        val editTextPhone = binding.editTextPhone
//        editTextPhone.setOnKeyListener{ view, keyCode, event ->
//            if (keyCode == KEYCODE_ENTER && event.action == ACTION_UP) {
//                btnNext.setOnClickListener {
//
//                }
//            }
//        }
//    }

}
