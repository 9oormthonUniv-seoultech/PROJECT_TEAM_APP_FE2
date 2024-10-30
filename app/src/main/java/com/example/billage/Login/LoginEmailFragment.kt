package com.example.billage.Login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginEmailBinding
import org.w3c.dom.Text

// Fragment index 4

class LoginEmailFragment : Fragment() {

    lateinit var binding : FragmentLoginEmailBinding
    private var cert: String = ""
    private lateinit var certNum : Array<EditText>

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
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }
}