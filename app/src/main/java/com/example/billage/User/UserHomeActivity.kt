package com.example.billage.User

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.billage.Login.LoginHomeFragment
import com.example.billage.R
import com.example.billage.databinding.ActivityUserHomeBinding

class UserHomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbarUserHome
        setSupportActionBar(toolbar)

        setContentView(binding.root)
        setContentView(R.layout.activity_user_home)

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<UserMapFragment>(R.id.fragmentUserPage)
            }
        }

        // 하단바 아이템 클릭 이벤트 설정
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.navHome -> {
                    changeFragment(0)
                    true
                }
                R.id.navSearch -> {
                    changeFragment(0)
                    true
                }
                R.id.navProfile -> {
                    changeFragment(0)
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_view, menu)

        // Searchable과 searchView 연결하기
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }

    fun changeFragment(index: Int){
        when(index){
            // UserMapFragment
            0 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragmentUserPage, UserMapFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}