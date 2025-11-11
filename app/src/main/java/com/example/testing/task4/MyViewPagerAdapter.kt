package com.example.testing.task4


import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class MyViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragList: MutableList<Fragment> = mutableListOf()

    override fun getItem(position: Int): Fragment {
        return fragList[position]
    }

    override fun getCount(): Int  = fragList.size

    fun addFragment(fragment:Fragment){
        fragList.add(fragment)
        notifyDataSetChanged()

        Log.i("CheckAdapter", fragList.toString())
    }

}