package com.example.testing.myTestingLesson

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.testing.R
import com.example.testing.databinding.ActivityTestingAppbarBinding

class TestingAppBar: AppCompatActivity() {
    var binding: ActivityTestingAppbarBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTestingAppbarBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding?.root){view, insets->
            val systemBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                systemBar.left,
                systemBar.top,
                systemBar.right,
                systemBar.bottom
            )
            insets
        }

        val navController = findNavController(R.id.navHost)

        val appBarConfig = AppBarConfiguration(setOf(R.id.firstFragment,R.id.secondFragment))

        setupActionBarWithNavController(navController,appBarConfig)

    }

}