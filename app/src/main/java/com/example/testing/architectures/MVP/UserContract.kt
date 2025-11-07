package com.example.testing.architectures.MVP



interface UserContract {

    interface Presenter{
        fun addUser(name: String)
        fun deleteUser(user: User)
        fun loadUser()
        fun attachView(view: View)
        fun detachView()
    }

    interface View{
        fun showUsers(users:List<User>)
    }

}