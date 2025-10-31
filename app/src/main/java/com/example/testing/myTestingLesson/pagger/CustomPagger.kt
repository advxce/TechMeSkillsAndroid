package com.example.testing.myTestingLesson.pagger

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testing.myTestingLesson.fragments.FirstFragment
import com.example.testing.myTestingLesson.fragments.SecondFragment
import com.example.testing.myTestingLesson.fragments.ThirdFragment

class CustomPagger(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0-> FirstFragment()
            1-> SecondFragment()
            else -> ThirdFragment()
        }
    }

    override fun getItemCount(): Int {
          return 3
    }
}