package com.example.billage.Login

import android.os.Bundle
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.toSpannable
import androidx.fragment.app.FragmentTransaction
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginHomeBinding

class LoginHomeFragment : Fragment() {

    private var _binding : FragmentLoginHomeBinding?= null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginHomeBinding.inflate(inflater, container, false) // binding 생성
        val view = binding.root
        binding.textViewRegister.setOnClickListener {
            (requireActivity() as LoginActivity).goRegister() } // 회원가입하기 텍스트를 누를 경우 회원가입 프래그먼트로 이동
        return view
    }
}