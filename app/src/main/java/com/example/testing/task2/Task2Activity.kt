package com.example.testing.task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.R
import com.example.testing.databinding.ActivityTask2Binding

class Task2Activity: AppCompatActivity() {

    var binding: ActivityTask2Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.let {bId->
            bId.tvWithUserName.text = getString(R.string.hello_with_username, "Dima")
            bId.btnWithStyle.setOnClickListener {
                Toast.makeText(this, "Buttin clicked", Toast.LENGTH_SHORT).show()
            }
            bId.btnAddName.setOnClickListener {
                bId.tvWithUserName.text = getString(R.string.hello_with_username, bId.editTvEnterName.text)
            }
        }

    }

}