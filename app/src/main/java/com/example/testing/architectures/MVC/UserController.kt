package com.example.testing.architectures.MVC

import android.os.Bundle

class UserController(
    val userRepository: UserRepository) {

    private var userView:UserView? = null

    fun attachView(view: UserView){
        userView = view
    }
    fun detachView(){
        userView = null
    }

    fun loadUsers(){
        val users = userRepository.getUsers()
        userView?.showUsers(users)

    }


    fun addUser(){
        userRepository.addUser()
        loadUsers()
    }

    fun deleteUser(user: User){
        userRepository.deleteUser(user)
        loadUsers()
    }

    fun saveState(outState: Bundle){
        userRepository.savaState().let {saveState->
            outState.putAll(saveState)
        }
    }

    fun restoreState(savedStateInstance: Bundle?){
        userRepository.restoreState(savedStateInstance)
    }

}