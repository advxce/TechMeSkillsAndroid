package com.example.testing.architectures.MVC

import android.os.Bundle
import java.io.Serializable


data class User(
    val id: Int,
    val name: String,
): Serializable{
}

class UserRepository{
    private val users: MutableList<User> = mutableListOf<User>(User(1,"Dima"))

    fun getUsers():List<User> = users.toList()



    fun addUser(): User{
        val newUser = User(users.size, "User ${users.size}")
        users.add(newUser)
        return newUser
    }

    fun deleteUser(user:User){
        users.remove(user)
    }

    fun savaState(): Bundle{
        return Bundle().apply {
            putSerializable("users", ArrayList(users))
        }
    }

    fun restoreState(saveStateInstance: Bundle?){
        users.clear()



        saveStateInstance?.let {bundle->
            val saveUsers = bundle.getSerializable("users") as? ArrayList<*>
            saveUsers?.forEach { user->
                if(user is User){
                    users.add(user)
                }
            }
        }
    }

}

