package com.example.billage.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginIdPwBinding


class LoginIdPwFragment : Fragment() {
    private var _binding : FragmentLoginIdPwBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginIdPwBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Toolbar 설정
        val toolbar : Toolbar = binding.toolbarLogin
        toolbar.setTitle(R.string.toolbar_register)
        toolbar.setNavigationIcon(R.drawable.icon_close_button)
        // Toolbar 뒤로가기
        toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}