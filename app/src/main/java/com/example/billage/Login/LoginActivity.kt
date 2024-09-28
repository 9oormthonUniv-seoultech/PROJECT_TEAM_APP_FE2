package com.example.billage.Login

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.add
import com.example.billage.Modal.ModalBottomSheet
import com.example.billage.R
import com.example.billage.databinding.ActivityLoginActicityBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginActicityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginActicityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<LoginHomeFragment>(R.id.fragmentLogin)
            }
        }
    }

//    fun goRegister(){
//        val loginIdPwFragment = LoginIdPwFragment()
//        val transaction = supportFragmentManager.beginTransaction() // transaction을 시작하고 변수에 저장
//        transaction.replace(R.id.frameLayoutLogin, loginIdPwFragment) // transaction에 loginIdPwFragment를 추가, 뷰바인딩으로 레이아웃을 갖고오면 안됨
//        transaction.addToBackStack("loginHome") // 백스택에 담아둠 -> 뒤로가기 버튼으로 트랜잭션 전체 제거 가능
//        transaction.commit()
//    }

    fun changeFragment(index : Int){
        when(index){
            // LoginIdPwFragment
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginIdPwFragment())
                    .commit()
            }
            // LoginPwFragment
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginPwFragment())
                    .commit()
            }
            // LoginStudnetInfoFragment
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginStudentInformFragment())
                    .commit()
            }
        }
    }
}