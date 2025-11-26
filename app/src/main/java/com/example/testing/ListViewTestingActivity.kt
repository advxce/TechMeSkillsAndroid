package com.example.testing

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.databinding.ActivityListViewTestingBinding
import com.example.testing.task1.CountViewModel

class ListViewTestingActivity:AppCompatActivity() {
//    var binding: ActivityListViewTestingBinding? = null
//
//    val countViewModel: CountViewModel by viewModels()
//
//    var recAdapter: RecAdapter? = null
//
//    val startList = listOf<Person>(
//        Person("dima"),
//        Person( "oleg"),
//        Person( "dima"),
//        Person( "andrey"),
//    )
//
//    val catList = listOf<String>(
//        "fo",
//        "fooo",
//        "fpfew",
//        "fewfewfew",
//        "efrw",
//        "oefeoppko",
//        )
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityListViewTestingBinding.inflate(layoutInflater)
//
//        setContentView(binding?.root)
//
//        val listAdapter = ArrayAdapter<String>(
//            this,
//            R.layout.item_list_testing,
//            catList
//        )
//
//        recAdapter = RecAdapter(startList)
//
//        withBinding {
//            recView.adapter = recAdapter
//            recView.layoutManager = LinearLayoutManager(this@ListViewTestingActivity)
//            returnDefaultList.setOnClickListener {
////                recAdapter.returnDefaultList()
//                recAdapter?.addRandNum(startList)
//            }
//
//            countViewModel.person.observe(this@ListViewTestingActivity) { list->
//                Log.i("Tag", "list $list")
//                recAdapter?.update(list)
//
//
//            }
//
//            search.setOnClickListener {
//                countViewModel.getFilterList(editPersonName.text.toString())
//
//            }
//
//
//
//        }
//
//
//
//    }
//
//    fun withBinding(block: ActivityListViewTestingBinding.()->Unit){
//        binding?.let {
//            block.invoke(it)
//        }
//    }
}