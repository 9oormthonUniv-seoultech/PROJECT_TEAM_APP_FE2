package com.example.billage.Admin.Reserve

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billage.AdminActivity
import com.example.billage.R
import com.example.billage.databinding.FragmentReserveBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.viewpager2.adapter.FragmentStateAdapter

class ReserveFragment : Fragment() {

    private lateinit var binding: FragmentReserveBinding
    private lateinit var adminActivity: AdminActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentReserveBinding.inflate(inflater, container, false)
        adminActivity = activity as AdminActivity

        val category: List<String> = listOf("일반", "기간", "반복")

        val adapter = TemplateCategoryVPAdapter(this)
        binding.viewpager.adapter = adapter

        TabLayoutMediator(binding.tab, binding.viewpager) { tab, position ->
            tab.text = category[position]  // 포지션에 따른 텍스트
        }.attach()  // 탭 레이아웃과 뷰페이저를 붙여주는 기능

        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    binding.viewpager.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        tabItemMargin(binding.tab)

        return binding.root
    }

    private fun tabItemMargin(mTabLayout: TabLayout) {
        for (i in 0 until mTabLayout.tabCount) {
            val tab = (mTabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            val p = tab.layoutParams as ViewGroup.MarginLayoutParams
            p.setMargins(14, 8, 14, 8)
            tab.requestLayout()
        }
    }
}

class TemplateCategoryVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3  // 일반, 기간, 반복 총 3개의 탭

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ReserveDefaultFragment()  // 일반 탭에 해당하는 Fragment
            1 -> ReserveDefaultFragment()  // 기간 탭에 해당하는 Fragment
            2 -> ReserveDefaultFragment()  // 반복 탭에 해당하는 Fragment
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
