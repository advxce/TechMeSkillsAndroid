package com.example.testing.architectures.MVVM

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testing.architectures.MVC.User

class MainViewModel() : ViewModel() {

    private val _user = MutableLiveData<List<UserMVVM>>(emptyList())
    val user: LiveData<List<UserMVVM>> get() = _user

    private var nextId = 1

    fun addUserMVVM(userName: String) {
        val currentList = _user.value ?: emptyList()
        val newUser = UserMVVM(nextId++, userName)
        _user.value = currentList + newUser

    }

    fun deleteUserMVVM(user: UserMVVM) {
        val currentList = _user.value ?: emptyList()
        _user.value = currentList - user
    }

    fun addUserWithAutoName() {
        addUserMVVM("Dima ${nextId}")
    }

    fun getUsersCount():Int = _user.value?.size ?: 0

}