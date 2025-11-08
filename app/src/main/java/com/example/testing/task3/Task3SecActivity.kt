package com.example.testing.task3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.databinding.ActivityTask3SecBinding

class Task3SecActivity:AppCompatActivity() {
    var binding: ActivityTask3SecBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask3SecBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.let {bId->
            bId.tvGetText.text = intent.getStringExtra(Task3Activity.HELLO_KEY)
        }
    }
}