package com.example.testing.task4

import android.graphics.Color
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.testing.R
import com.example.testing.databinding.ActivityTask4Binding
import com.example.testing.task4.task4Fragments.FirstTask4Fragment
import com.example.testing.task4.task4Fragments.FourthTask4Fragment
import com.example.testing.task4.task4Fragments.SecondTask4Fragment
import com.example.testing.task4.task4Fragments.ThirdTask4Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class Task4Activity : AppCompatActivity() {


    var count: Int = 0
    var binding: ActivityTask4Binding? = null
    var myPagerAdapter: MyViewPagerAdapter? = null

    override fun onCreate(saveStateInstance: Bundle?) {
        super.onCreate(saveStateInstance)
        binding = ActivityTask4Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        Log.i("CheckAdapter", "OnCreate")

        myPagerAdapter = MyViewPagerAdapter(supportFragmentManager)


        withBinding {

            pgTask4.adapter = myPagerAdapter
            addFrag.setOnClickListener {
                Log.i("CheckAdapter", "Btn work")
                addNewFragment()

            }

            val snackBar = Snackbar.make(binding!!.root, "Check snackBar", Snackbar.LENGTH_LONG)
                .setAction("Cancel") {
                    Toast.makeText(this@Task4Activity, "Cancelled action", Toast.LENGTH_SHORT)
                        .show()
                }
            snackBar.setActionTextColor(Color.RED)
            btnShowSnackBar.setOnClickListener {

                snackBar.show()
            }

        }


    }

    fun addNewFragment() {
        count++
        val newFragment: Fragment = when (count) {
            1 -> FirstTask4Fragment()
            2 -> SecondTask4Fragment()
            3 -> ThirdTask4Fragment()
            else -> {
                count = 0
                FourthTask4Fragment()

            }
        }
        myPagerAdapter?.addFragment(newFragment)

        val newPosition = (myPagerAdapter?.count ?: 1) - 1
        binding?.pgTask4?.currentItem = newPosition

    }

    fun withBinding(block: ActivityTask4Binding.() -> Unit) {
        binding?.let {
            block.invoke(it)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}