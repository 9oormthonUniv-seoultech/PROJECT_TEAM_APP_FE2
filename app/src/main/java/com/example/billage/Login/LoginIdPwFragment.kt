package com.example.billage.Login

import android.content.SharedPreferences.Editor
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import androidx.core.content.ContextCompat
import androidx.core.view.isNotEmpty
import androidx.core.widget.addTextChangedListener
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
        setStudentIdCheck()
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

    // 학번 입력 시 EditText의 디자인 변환
    private fun setStudentIdCheck(){
        var isStudentChecked : Boolean = false
        var isNameEntered : Boolean = false
        var isPhoneEntered : Boolean = false
        // 이메일 입력 감지
        binding.editTextStudentId.addTextChangedListener(object : TextWatcher {
            // 학번 입력 전
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            // 학번 입력 중
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.editTextStudentId.text.toString() == "19101563") {
                    binding.imageViewStudentIdCheck.visibility = View.VISIBLE
                    binding.imageViewStudentIdCheck.setImageResource(R.drawable.icon_student_id_checked)
                    binding.textViewStudentIdCondition.text = getString(R.string.textview_student_id_checked)
                    binding.textViewStudentIdCondition.setTextColor(ContextCompat.getColor(context!!, R.color.color1))
                    binding.textViewStudentIdCondition.setTypeface(null, Typeface.BOLD)
                    isStudentChecked = true
                }
                else if (binding.editTextStudentId.text.length != 8){
                    binding.imageViewStudentIdCheck.visibility = View.VISIBLE
                    binding.imageViewStudentIdCheck.setImageResource(R.drawable.icon_student_id_error)
                    binding.textViewStudentIdCondition.text = getString(R.string.textview_student_id_length)
                    binding.textViewStudentIdCondition.setTextColor(ContextCompat.getColor(context!!, R.color.error))
                    binding.textViewStudentIdCondition.setTypeface(null, Typeface.BOLD)
                    isStudentChecked = false
                }
                else {
                    binding.imageViewStudentIdCheck.visibility = View.VISIBLE
                    binding.imageViewStudentIdCheck.setImageResource(R.drawable.icon_student_id_error)
                    binding.textViewStudentIdCondition.text = getString(R.string.textview_student_id_error)
                    binding.textViewStudentIdCondition.setTextColor(ContextCompat.getColor(context!!, R.color.error))
                    binding.textViewStudentIdCondition.setTypeface(null, Typeface.BOLD)
                    isStudentChecked = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                if (isStudentChecked == true){
                }
            }

        })

        binding.editTextName.addTextChangedListener {
            isNameEntered = binding.editTextName.text?.toString()?.isNotEmpty() == true
            btnEnabled(isStudentChecked, isNameEntered, isPhoneEntered)
        }
        binding.editTextPhone.addTextChangedListener {
            isPhoneEntered = binding.editTextPhone.text?.toString()?.isNotEmpty() == true
            btnEnabled(isStudentChecked, isNameEntered, isPhoneEntered)
        }
    }

    private fun btnEnabled(isStudentCheced: Boolean, isNameEntered: Boolean, isPhoneEntered: Boolean){
        binding.buttonLoginNext.isEnabled = isStudentCheced && isNameEntered && isPhoneEntered
    }
}
