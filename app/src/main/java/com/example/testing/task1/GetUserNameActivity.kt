package com.example.testing.task1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.databinding.ActivityGetUserNameBinding

class GetUserNameActivity: AppCompatActivity() {

    var binding: ActivityGetUserNameBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGetUserNameBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val userName = intent.getStringExtra(SecondActivity.USER_DATA_KEY)

        binding?.let {
            it.tvGetUserName.text = userName
        }
    //testing
    }

}