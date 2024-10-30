package com.example.billage.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.example.billage.R
import com.example.billage.databinding.FragmentLoginEmailBinding

// Fragment index 4

class LoginEmailFragment : Fragment() {

    lateinit var binding : FragmentLoginEmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentLoginEmailBinding.inflate(inflater, container, false)

        binding.buttonEmailNext.setOnClickListener {

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
}