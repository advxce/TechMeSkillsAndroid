package com.example.testing.myTestingLesson.fragments

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.testing.R

class FirstFragment: Fragment(R.layout.fragment_first) {


    override fun onResume() {
        super.onResume()
        Log.i("Check", "Show")
    }
}