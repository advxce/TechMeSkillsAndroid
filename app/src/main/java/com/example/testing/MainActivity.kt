package com.example.testing


import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.architectures.MVC.MainMVCActivity
import com.example.testing.architectures.MVP.MainMVPActivity

import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.task1.SecondActivity
import com.example.testing.task7.cleanArchitecture.presentation.view.KeepNoteActivity

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
            bId.task7.setOnClickListener {
                val toTask7Intent = Intent(this, KeepNoteActivity::class.java)
                startActivity(toTask7Intent)
            }

            bId.checkMVC.setOnClickListener {
                val toMVCIntent = Intent(this, MainMVCActivity::class.java)
                startActivity(toMVCIntent)
            }

            bId.checkMVP.setOnClickListener {
                val toMVPIntent = Intent(this, MainMVPActivity::class.java)
                startActivity(toMVPIntent)
            }
        }


    }
}