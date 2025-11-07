package com.example.testing.architectures.MVP

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.databinding.ActivityMvpMainBinding


class MainMVPActivity: AppCompatActivity(), UserContract.View {

    var binding: ActivityMvpMainBinding? = null
    var myCustomAdapter: UserMVPAdapter? = null
    var userPresenter: UserContract.Presenter? = null
    var counter:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val userRepository = UserRepository()

        userPresenter = PresenterImpl(userRepository)

        myCustomAdapter = UserMVPAdapter(emptyList()){ user->
            userPresenter?.deleteUser(user)
        }

        setupRecyclerView()
        setupComponents()
    }

    override fun onResume() {
        super.onResume()
        userPresenter?.attachView(this)
        userPresenter?.loadUser()
    }

    override fun onPause() {
        super.onPause()
        userPresenter?.detachView()
    }

    fun setupRecyclerView(){
        binding?.let {
            it.recView.adapter = myCustomAdapter
            it.recView.layoutManager = LinearLayoutManager(this)
        }

    }

    fun setupComponents(){
        binding?.let {bId->
            bId.addUser.setOnClickListener {
                userPresenter?.addUser("Oleg $counter")
                counter++

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showUsers(users: List<User>) {
        myCustomAdapter?.updateUsers(users)
        Log.i("UsersMVP", myCustomAdapter?.updateUsers(users).toString())
    }

}