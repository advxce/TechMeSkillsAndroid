package com.example.testing.myTestingLesson.pagger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testing.R
import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.databinding.ActivityTestingPaggerBinding
import com.google.android.material.tabs.TabLayoutMediator

class TestingPagger : AppCompatActivity() {

    var binding: ActivityTestingPaggerBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = ActivityTestingPaggerBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding?.root) { v, inset ->
            val pad = inset.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                pad.left,
                pad.top,
                pad.right,
                pad.bottom
            )
            inset
        }

        val myAdapter = CustomPagger(this)
        binding?.let {
            it.viewPager.adapter = myAdapter
            TabLayoutMediator(it.tab, it.viewPager) { tab, pos ->
                tab.text = when (pos) {
                    0 -> "Tab 1"
                    1 -> "Tab 2"
                    else -> "Tab 3"
                }

            }.attach()
        }


    }
}