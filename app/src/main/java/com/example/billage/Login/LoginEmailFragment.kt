package com.example.billage.Login

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.billage.Login.Modal.ModalBottomSheet.Companion.TAG
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginEmailBinding
import org.w3c.dom.Text

// Fragment index 4

class LoginEmailFragment : Fragment() {

    lateinit var binding : FragmentLoginEmailBinding
    private var cert: String = ""
    private lateinit var certNum : Array<EditText>
    lateinit var acceptCode : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentLoginEmailBinding.inflate(inflater, container, false)

        certNum = arrayOf(
            binding.signCertNum1,
            binding.signCertNum2,
            binding.signCertNum3,
            binding.signCertNum4,
            binding.signCertNum5,
            binding.signCertNum6
        )

        setCertNumOnTextChangedListener()
        onDelKeyListener()
        binding.buttonAccept.setOnClickListener{
            onClickButtonListener()
        }

        // 다음으로 버튼 누르면 넘어가기
        binding.buttonEmailNext.setOnClickListener {
            (activity as LoginActivity).changeFragment(5)
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

        // 이메일 형식 입력 시 인증하기 버튼 활성화
        setAcceptBTN()
    }


    private fun onClickButtonListener(): View.OnClickListener? {
        return View.OnClickListener {
            if (cert.length != 6) {
                Toast.makeText(requireContext(), "인증번호를 전부 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                for (i in 0..5) cert += certNum[i].text
                Toast.makeText(requireContext(), cert, Toast.LENGTH_SHORT).show()
            }
        }
    }

    // 키를 지우면 포커스 왼쪽 블럭으로 넘어감
    private fun onDelKeyListener(){
        for(idx in 1..5) certNum[idx].setOnKeyListener { view : View, i : Int, keyEvent : KeyEvent ->
            if (i == KeyEvent.KEYCODE_DEL && certNum[idx].text.isEmpty()) {
                certNum[idx - 1].requestFocus()
                certNum[idx - 1].text = null
                true
            } else{
                false
            }
        }
    }

    // 키를 입력하면 포커스 오른쪽 블럭으로 넘어감
    private fun setCertNumOnTextChangedListener(){
        for (idx in 0 until certNum.size - 1) certNum[idx].addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s?.length ==  1){
                    certNum[idx + 1].requestFocus()
                }
                acceptCode = certNum.joinToString("") { it.text.toString() }
            }

            override fun afterTextChanged(s: Editable?) {
                Log.d(TAG, "afterTextChanged: ${s}")
            }
        })
        
        binding.signCertNum6.apply{
            setOnFocusChangeListener { view, hasFocus ->
                if (hasFocus){
                    this.setSelection(this.text.length)
                }
            }
            addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    Log.d(TAG, "onTextChanged: ${certNum[5]}")
                    acceptCode += "${s}"
                    if (acceptCode == "abcdef"){
                        binding.textViewCodeInput.apply {
                            setTextColor(ContextCompat.getColor(context!!, R.color.color1))
                            setText("인증되었습니다!")
                            binding.buttonEmailNext.isEnabled = true // 학교 이메일 인증 까지 했을 때 버튼 활성화로 바꾸기
                        }
                    } else if (acceptCode.length == certNum.size){
                        binding.textViewCodeInput.apply {
                            setTextColor(ContextCompat.getColor(context!!, R.color.error))
                            setText("인증 실패했습니다\n다시 한 번 확인해주세요")
                            binding.buttonEmailNext.isEnabled = false
                        }
                    }
                    binding.signCertNum6.clearFocus()
                    if (s?.isNullOrEmpty() == true){
                        certNum[0].requestFocus()
                        for (i in 0..4){
                            certNum[i].text = null
                        }
                        binding.buttonEmailNext.isEnabled = false
                        binding.textViewCodeInput.apply{
                            setText("인증 코드를 입력해주세요")
                            setTextColor(ContextCompat.getColor(context!!, R.color.G3))
                        }
                    }
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
        }
    }

    // 이메일을 입력할 경우 인증버튼 활성화
    private fun setAcceptBTN(){
        val email = binding.editTextEmail
        val btnAccept = binding.buttonAccept

        email.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (s?.contains("@seoultech.ac.kr") == true){
                    btnAccept.apply {
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.wh))
                        isEnabled = true
                    }
                }else{
                    btnAccept.apply {
                        setTextColor(ContextCompat.getColor(requireContext(), R.color.color1))
                        isEnabled = false
                    }
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }
}