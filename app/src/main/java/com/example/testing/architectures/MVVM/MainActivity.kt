package com.example.testing.architectures.MVVM

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.databinding.ActivityMvvmTestingBinding
import com.example.testing.databinding.ActivityTestingCustomViewsBinding

class MainActivity: AppCompatActivity() {

    private var _binding: ActivityMvvmTestingBinding? = null
    val binding: ActivityMvvmTestingBinding get() = _binding!!
    val myViewModel: MainViewModel by viewModels()
    var adapter: UserMVVMAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMvvmTestingBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adapter = UserMVVMAdapter() {user->
            deleteUser(user)
        }

        setupRecView()
        setupComponents()
        setupObservers()
    }

    fun setupObservers(){
        myViewModel.user.observe(this) { list->
            adapter?.addUserMVVM(list)
        }
    }

    fun setupRecView() = with(binding){
        recView.adapter = adapter

        recView.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    fun setupComponents() = with(binding){
        btnAddUser.setOnClickListener {

            myViewModel.addUserWithAutoName()


            Log.i("MVVM", myViewModel.user.value!!.toString())
        }
    }

    fun deleteUser(user: UserMVVM){
        myViewModel.deleteUserMVVM(user)
        Log.i("MVVM", myViewModel.user.value!!.toString())

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}