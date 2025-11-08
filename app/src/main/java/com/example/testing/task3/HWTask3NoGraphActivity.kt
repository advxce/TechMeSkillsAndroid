package com.example.testing.task3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.R
import com.example.testing.task3.fragments.HomeFragment
import com.example.testing.task3.fragments.HomeNoGraphFragment

class HWTask3NoGraphActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw_task3_no_graph)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerNoGraph, HomeNoGraphFragment())
            .addToBackStack(null)
            .commit()
    }

}