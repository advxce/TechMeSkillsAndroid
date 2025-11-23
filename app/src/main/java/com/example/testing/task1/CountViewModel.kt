package com.example.testing.task1

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testing.Person
import kotlin.collections.listOf

class CountViewModel: ViewModel() {

    private val startedList = listOf<Person>(
        Person("dima"),
        Person( "oleg"),
        Person( "dima"),
        Person( "andrey"),
    )

    private val _persons = MutableLiveData<List<Person>>( startedList )
    val person: LiveData<List<Person>>
        get() = _persons


    fun getFilterList(name:String){
        _persons.value = startedList.filter { it.name ==  name}
        Log.i("Tag", _persons.value.toString())
    }

}