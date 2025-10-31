//package com.example.testing
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.util.AttributeSet
//import android.view.View
//
//class MyCustomView(context: Context, attrs: AttributeSet?): View(context, attrs) {
//
//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
//        val canvas = Canvas()
//        draw(canvas)
//
//    }
//
//
//    @SuppressLint("DrawAllocation")
//    override fun onDraw(canvas: Canvas) {
//        super.onDraw(canvas)
//
//        val paint= Paint()
//        paint.strokeWidth = 2f
//        paint.color = Color.RED
//
//        canvas.drawOval(10f, 10f, 10f,10f,paint)
//
//        draw(canvas)
//
//    }
//
//}
//
//class ProfileViewModel(
//    context: Context
//) : ViewModel() {
//
//    private val context = context.applicationContext
//
//    private val _userData: MutableLiveData<User> = MutableLiveData(User())
//    val userData:LiveData<User> get() = _userData
//
//    fun loadUserProfile() {
//        val userId = SecureStorage.getUserId(context)
//        NetworkClient.api.getUserDetails(userId).enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if (response.isSuccessful) {
//                    userData.postValue(response.body())
//                } else {
//                    Log.e("Error", "Failed to load user data")
//                }
//            }
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                userData.postValue(null)
//            }
//        })
//    }
//
//    fun saveUser(user: User) {
//        Database.getInstance(context).userDao().insertUser(user)
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//    }
//}
//object SecureStorage {
//    fun getUserId(context: Context): String {
//        return context.getSharedPreferences("prefs", Context.MODE_PRIVATE).getString("userId", "")!!
//    }
//}
//object NetworkClient {
//    val api: ApiService = Retrofit.Builder()
//        .baseUrl("https://api.example.com/")
//        .build()
//        .create(ApiService::class.java)
//}
