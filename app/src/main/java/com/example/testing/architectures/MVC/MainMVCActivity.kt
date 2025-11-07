package com.example.testing.architectures.MVC

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.databinding.ActivityMvcMainBinding
import com.example.testing.myTestingLesson.MyCustomAdapter

class MainMVCActivity : AppCompatActivity(), UserView {

    var binding: ActivityMvcMainBinding? = null
    var adapter: UserMVCAdapter? = null


    var userController: UserController? = null

    override fun onCreate(saveStateInstance: Bundle?) {
        super.onCreate(saveStateInstance)

        binding = ActivityMvcMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        var userRepository: UserRepository = UserRepository()



        userController = UserController(userRepository)

        if(saveStateInstance!=null){
            userController?.restoreState(saveStateInstance)
        }

            adapter = UserMVCAdapter(emptyList()) { user ->
                userController?.deleteUser(user)

            }



        binding?.let { bId ->

            bId.recView.let {

                it.adapter = adapter
                it.layoutManager = LinearLayoutManager(this)
            }
            bId.addUser.setOnClickListener {
                onAdd()
            }

        }

    }

    override fun onStart() {
        super.onStart()
        userController?.attachView(this)
        userController?.loadUsers()
    }

    override fun onStop() {
        super.onStop()
        userController?.detachView()
    }

    fun onAdd() {
        userController?.addUser()
//        Log.i("Users", "usersAdd: ${userController?.loadUsers()}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        userController?.saveState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    override fun showUsers(users: List<User>) {
        adapter?.updateUsers(users)

        Log.i("Users", "usersShow: ${adapter?.updateUsers(users)}")
    }

    override fun onError() {
        Toast.makeText(this, "Empty list", Toast.LENGTH_SHORT).show()
    }

}