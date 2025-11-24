package com.example.testing


import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.architectures.MVC.MainMVCActivity
import com.example.testing.architectures.MVP.MainMVPActivity
import com.example.testing.architectures.MVVM.MainActivity
import com.example.testing.customViews.TestingCustomViewsActivity

import com.example.testing.databinding.ActivityMainBinding
import com.example.testing.task1.CountViewModel
import com.example.testing.task1.SecondActivity
import com.example.testing.task6.Task6Activity

import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null


    val countViewModel: CountViewModel by viewModels()


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
            bId.task6.setOnClickListener {
                val toTask6Intent = Intent(this, Task6Activity::class.java)
                startActivity(toTask6Intent)
            }
            bId.bottomBtnView.setOnClickListener {
                val toBottomBtnView = Intent(this, TestingCustomViewsActivity::class.java )
                startActivity(toBottomBtnView)
            }
            bId.checkMVC.setOnClickListener {
                val toMVCIntent = Intent(this, MainMVCActivity::class.java)
                startActivity(toMVCIntent)
            }

            bId.checkMVP.setOnClickListener {
                val toMVPIntent = Intent(this, MainMVPActivity::class.java)
                startActivity(toMVPIntent)
            }
            bId.checkMVVM.setOnClickListener{
                val toMVVMIntent = Intent(this, MainActivity::class.java)
                startActivity(toMVVMIntent)
            }
            bId.toRec.setOnClickListener {
                val toRecIntent = Intent(this, ListViewTestingActivity::class.java)
                startActivity(toRecIntent)
            }



//            countViewModel.count.observe(this) { count->
//                bId.getCountTv.text = count.toString()
//            }
//
//
//            bId.incCount.setOnClickListener {
//                countViewModel.incCount()
//            }
        }




    }
}