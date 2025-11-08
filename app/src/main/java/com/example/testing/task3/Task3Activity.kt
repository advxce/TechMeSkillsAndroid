package com.example.testing.task3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.R
import com.example.testing.databinding.ActivityTask3Binding
import com.example.testing.task3.fragments.Task3Fragment
import com.example.testing.task3.fragments.Task3FragmentB

class Task3Activity : AppCompatActivity() {

    var binding: ActivityTask3Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask3Binding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.let { bId ->
            bId.goToBrowser.setOnClickListener {
//                val browserIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+37529601****"))
                val browserIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                startActivity(browserIntent)
            }
            bId.toTask3SecActivity.setOnClickListener {
                val task3SecIntent = Intent(this, Task3SecActivity::class.java)
                task3SecIntent.putExtra(HELLO_KEY,"hello, second activity")
                startActivity(task3SecIntent)
            }

            bId.addFragments.setOnClickListener {

                val task3Frag = Task3Fragment().apply {
                    arguments = Bundle().apply {
                        putString("txt", "Data from Activity")
                    }
                }

                supportFragmentManager.beginTransaction()
                    .add(R.id.fragContainerView, task3Frag)
                    .commit()
            }

            bId.replaceFragments.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragContainerView, Task3FragmentB())
                    .commit()
            }

            bId.toHWTask3.setOnClickListener {
                val toHW3TaskIntent = Intent(this, HWTask3Activity::class.java)
                startActivity(toHW3TaskIntent)
            }

            bId.toHWTask3NoGraph.setOnClickListener {
                val toHW3TaskNoGraphIntent = Intent(this, HWTask3Activity::class.java)
                startActivity(toHW3TaskNoGraphIntent)
            }

        }


    }

    companion object{
        const val HELLO_KEY = "hello_key"
    }

}