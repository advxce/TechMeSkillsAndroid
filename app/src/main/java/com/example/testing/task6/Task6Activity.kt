package com.example.testing.task6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.R
import com.example.testing.databinding.ActivityTask6Binding
import com.example.testing.task6.adapter.ListMargin
import com.example.testing.task6.adapter.MultiTypeAdapter
import com.example.testing.task6.adapter.MyListAdapter
import com.example.testing.task6.entity.AuthorData
import com.example.testing.task6.entity.ButtonData
import com.example.testing.task6.entity.Entities
import com.example.testing.task6.entity.PictureData

class Task6Activity: AppCompatActivity() {

    private var multiAdapter: MultiTypeAdapter? = null
    private var listAdapter: MyListAdapter? = null

    val startList = listOf<Entities>(
        Entities.AuthorData("Dima", "gregrgregrsdfsdfs"),
        Entities.ButtonData("Check btn"),
        Entities.PictureData(R.drawable.settings, "ewfwefwe"),
        Entities.ButtonData("Check btn"),

    )

    val list: MutableList<Entities> = startList.toMutableList()

    var binding: ActivityTask6Binding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTask6Binding.inflate(layoutInflater)
        setContentView(binding?.root)
        listAdapter = MyListAdapter()

        multiAdapter = MultiTypeAdapter()
//        multiAdapter?.load(list)
        binding?.let {
            with(it) {
                recView.adapter = listAdapter
                recView.layoutManager = LinearLayoutManager(this@Task6Activity)
                recView.addItemDecoration(ListMargin(200))
                listAdapter?.submitList(list.toList())


                addPicture.setOnClickListener {

                    val newItem = Entities.PictureData(R.drawable.settings, "ewfwefwe")
                    list.add(newItem)
                    recView.invalidateItemDecorations()


//                    multiAdapter?.update(PictureData(R.drawable.settings, "ewfwefwe"))
                }
                swipeRefresh.setOnRefreshListener {
                    listAdapter?.submitList(list.toList())

                    swipeRefresh.isRefreshing = false

                }
            }
        }
    }

}