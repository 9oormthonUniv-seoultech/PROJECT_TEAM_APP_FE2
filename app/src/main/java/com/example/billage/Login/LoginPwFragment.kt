package com.example.billage.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginIdPwBinding
import com.example.billage.databinding.FragmentLoginPwBinding

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Toolbar 설정
        val toolbar : Toolbar = binding.toolbarPw
        toolbar.setTitle(R.string.toolbar_registerPw)
        toolbar.setNavigationIcon(R.drawable.icon_back_button)
        // Toolbar 뒤로가기
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.popBackStack() // 뒤로가기
        }
    }

}