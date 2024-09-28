package com.example.billage.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        // 회원가입하기 텍스트를 누를 경우 LoginIdPwFragment로 이동
        binding.textViewRegister.setOnClickListener {
            (activity as LoginActivity).changeFragment(1)
        }
        return view
    }
}