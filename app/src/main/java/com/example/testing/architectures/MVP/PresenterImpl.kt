package com.example.testing.architectures.MVP

class PresenterImpl(
    val userRepository: UserRepository
) : UserContract.Presenter {
    private var userView: UserContract.View? = null

    override fun addUser(name: String) {
        userRepository.addUser(name)
        loadUser()
    }

    override fun deleteUser(user: User) {
        userRepository.deleteUser(user)
        loadUser()
    }

    override fun loadUser() {
        val users = userRepository.getUsers()
        userView?.showUsers(users)
    }

    override fun attachView(view: UserContract.View) {
        userView = view
    }

    override fun detachView() {
        userView = null
    }

}