package com.example.billage.Login

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginIdPwBinding
import com.example.billage.databinding.FragmentLoginPwBinding

// Fragment Index 2

class LoginPwFragment : Fragment() {

    lateinit var binding: FragmentLoginPwBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginPwBinding.inflate(inflater, container, false)
        // 다음으로 버튼을 누를 경우 LoginPwFragment로 이동
        binding.buttonPwNext.setOnClickListener {
            (activity as LoginActivity).changeFragment(3)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Toolbar 설정
        val navigationBtn : ImageButton = binding.imageButtonNavigation
        // Toolbar 뒤로가기
        navigationBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // 뒤로가기
        }

        // 비밀번호 viewBinding 변수들
        val pwText = binding.editTextPw
        val eyeIconPw = binding.imageViewPwEyeCheck
        val pwCheckText = binding.editTextPwCheck
        val eyeIconPwCheck = binding.imageViewPwCheckEyeCheck

        // 비밀번호 표시 토글
        toggleMakePwEye(eyeIconPw, pwText)
        toggleMakePwEye(eyeIconPwCheck, pwCheckText)
        setPwCheck()
    }

    // 비밀번호 보이게하는 토글
    fun toggleMakePwEye(eyeIcon: ImageView, pwText: EditText){
        eyeIcon.setOnClickListener {
            when(it.tag){
                "0" -> {
                    eyeIcon.tag = "1"
                    pwText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                    eyeIcon.setImageResource(R.drawable.icon_eye_closed)
                }
                "1" -> {
                    eyeIcon.tag = "0"
                    pwText.transformationMethod = PasswordTransformationMethod.getInstance()
                    eyeIcon.setImageResource(R.drawable.icon_eye_open)
                }
            }
            pwText.setSelection(pwText!!.length())
        }
    }


    private fun setPwCheck(){
        var isPwChecked : Boolean = false
        var isPwDoubleChecked : Boolean = false
        val textPw = binding.editTextPw
        val textPwDouble = binding.editTextPwCheck
        // 특수문자 정규식
        val specialCharPattern = Regex("[!@#\$%^&*(),.?\":{}|<>]")

        textPw.addTextChangedListener {
            val password = textPw.text.toString()
            if(textPw.text.toString().length >= 8 && textPw.text.toString().length <= 16 && specialCharPattern.containsMatchIn(password)){
                binding.textViewEnglishCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                binding.textViewCharCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                binding.editTextPw.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_checked)
                isPwChecked = true
                btnEnabled(isPwChecked, isPwDoubleChecked)
            }
            else if (specialCharPattern.containsMatchIn(password)){
                binding.textViewEnglishCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                binding.textViewCharCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                binding.editTextPw.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_error)
                isPwChecked = false
                btnEnabled(isPwChecked, isPwDoubleChecked)

            }
            else if (textPw.text.toString().length >= 8 && textPw.text.toString().length <= 16){
                binding.textViewEnglishCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                binding.textViewCharCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                binding.editTextPw.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_error)
                isPwChecked = false
                btnEnabled(isPwChecked, isPwDoubleChecked)
            }
            else {
                binding.textViewEnglishCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                binding.textViewCharCondition.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                binding.editTextPw.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_error)
                isPwChecked = false
                btnEnabled(isPwChecked, isPwDoubleChecked)
            }
        }
        textPwDouble.addTextChangedListener {
            val password = textPw.text.toString()
            val passwordDouble = textPwDouble.text.toString()
            val textViewPwCheck = binding.textViewPwDoubleCheck
            if (password == passwordDouble){
                textViewPwCheck.text = "비밀번호 확인 완료"
                textViewPwCheck.setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                binding.editTextPwCheck.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_checked)
                isPwDoubleChecked = true
                btnEnabled(isPwChecked, isPwDoubleChecked)
            }
            else {
                textViewPwCheck.text = "비밀번호가 틀립니다"
                textViewPwCheck.setTextColor(ContextCompat.getColor(requireContext(), R.color.error))
                binding.editTextPwCheck.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_edittext_error)
                isPwDoubleChecked = false
                btnEnabled(isPwChecked, isPwDoubleChecked)
            }
        }
    }

    private fun btnEnabled(isPwChecked: Boolean, isPwDouble: Boolean){
        binding.buttonPwNext.isEnabled = isPwDouble && isPwChecked
    }

}