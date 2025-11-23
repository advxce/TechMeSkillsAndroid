package com.example.testing.customViews

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.testing.databinding.ActivityTestingCustomViewsBinding

class TestingCustomViewsActivity: AppCompatActivity() {

    private val token = Any()
    private var handler = Handler(Looper.getMainLooper())
    private var binding: ActivityTestingCustomViewsBinding?= null

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestingCustomViewsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.bottomButtonView?.setListener {

            when(it){
                BottomButtonAction.NEGATIVE ->{
                    binding?.bottomButtonView?.setNegativeBtnTxt("newText")
                    Toast.makeText(this, "Shaw negative listener", Toast.LENGTH_SHORT).show()
                }
                BottomButtonAction.POSITIVE -> {
                    binding?.bottomButtonView?.isProgressModeState(true)
                    handler.postDelayed({
                        binding?.bottomButtonView?.isProgressModeState(false)
                        Toast.makeText(this, "Shaw positive listener", Toast.LENGTH_SHORT).show()
                    }, token, 2000)

                }

            }
        }

//        binding?.bottomButtonView?.setNegativeBtnTxt("newText")
//        binding?.bottomButtonView?.isProgressModeState(true)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}