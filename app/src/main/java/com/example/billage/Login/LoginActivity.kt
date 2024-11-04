package com.example.billage.Login

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.add
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

    fun changeFragment(index : Int){
        when(index){
            // LoginHomeFragment
            0 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginHomeFragment())
                    .addToBackStack(null)
                    .commit()
            }
            // LoginIdPwFragment
            1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginIdPwFragment())
                    .addToBackStack(null)
                    .commit()
            }
            // LoginPwFragment
            2 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginPwFragment())
                    .addToBackStack(null)
                    .commit()
            }
            // LoginStudnetInfoFragment
            3 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginStudentInformFragment())
                    .addToBackStack(null)
                    .commit()
            }
            // LoginEmailFragment
            4 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginEmailFragment())
                    .addToBackStack(null)
                    .commit()
            }
            // LoginAgreeFragment
            5 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentLogin, LoginAgreeFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

}