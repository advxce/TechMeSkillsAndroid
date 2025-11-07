package com.example.testing.architectures.MVP

data class User(
    val id:Int,
    val name:String,
)


class UserRepository{
    private val users = mutableListOf<User>(User(id = 0, name = "Dima"))

    fun getUsers():List<User> = users.toList()

    fun addUser(userName:String){
        val newUser = User(id = users.size, userName)
        users.add(newUser)
    }

    fun deleteUser(user: User){
        users.remove(user)
    }
}