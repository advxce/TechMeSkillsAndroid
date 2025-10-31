package com.example.testing


import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.task1.SecondActivity
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding?.root){view,insets->
            val statusBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                statusBar.left,
                statusBar.top,
                statusBar.right,
                statusBar.bottom
            )
            insets
        }

        binding?.let { bId->
            bId.toSecActivity.setOnClickListener {
                val toSecActIntent = Intent(this, SecondActivity::class.java)
                startActivity(toSecActIntent)
            }
        }


    }
}