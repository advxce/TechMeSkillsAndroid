package com.example.testing.task5

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.databinding.ActivityTask5Binding

class Task5Activity : AppCompatActivity() {

    var binding: ActivityTask5Binding? = null
    var recViewAdapter: Task5RecViewAdapter? = null
    var state: Boolean = false
    val list = mutableListOf<UserDataTask5>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask5Binding.inflate(layoutInflater)
        setContentView(binding?.root)




        Log.i("Check task5", "${state}")
        withBinding {
            recViewAdapter = Task5RecViewAdapter(tvInfoTask5)

            task5RecView.adapter = recViewAdapter
            task5RecView.layoutManager = LinearLayoutManager(this@Task5Activity)

            recViewAdapter?.addUser(list)

            task5AddUser.setOnClickListener {
                Log.i("Check task5", "${state}")
                state = true
                list.add(UserDataTask5(id = list.size, name = "User ${list.size}"))
                recViewAdapter?.addUser(list)
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

    }

    fun withBinding(block: ActivityTask5Binding.() -> Unit) {
        binding?.let {
            block.invoke(it)
        }
    }

}