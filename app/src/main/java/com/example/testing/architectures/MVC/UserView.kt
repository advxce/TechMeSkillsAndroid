package com.example.testing.architectures.MVC

interface UserView {
    fun showUsers(users:List<User>)
    fun onError()
}