package com.example.testing


import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.task1.SecondActivity
import com.example.testing.task2.Task2Activity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        binding?.let {bId->
            bId.task1.setOnClickListener {
                val toTask1Intent = Intent(this, SecondActivity::class.java)
                startActivity(toTask1Intent)
            }

            bId.task2.setOnClickListener {
                val toTask2Intent = Intent(this, Task2Activity::class.java)
                startActivity(toTask2Intent)
            }
        }


    }
}