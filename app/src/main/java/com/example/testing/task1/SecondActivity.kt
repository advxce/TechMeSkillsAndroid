package com.example.testing.task1

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testing.R
import com.example.testing.databinding.ActivitySecondBinding
import com.example.testing.myTestingLesson.MyCustomAdapter
//add task1
class SecondActivity : AppCompatActivity() {

    var binding: ActivitySecondBinding? = null
    var wifiBroadCastReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)
//        setContentView(R.layout.activity_second)
//        val rootView = layoutInflater.inflate(R.layout.activity_second, null, false) as LinearLayout
//        val parentView = findViewById<ViewGroup>(R.id.sec_activity)
        ViewCompat.setOnApplyWindowInsetsListener(binding?.root) { view, insets ->
            val statusBar = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(
                statusBar.left,
                statusBar.top,
                statusBar.right,
                statusBar.bottom
            )
            insets
        }

        binding?.let { bId ->

            bId.tvUserName.text = getString(R.string.user_name)
            bId.toNextActivity.setOnClickListener {
                var userName: String = bId.editTxtUserName.text.toString()

                val userData = Intent(this, GetUserNameActivity::class.java)
                userData.putExtra(USER_DATA_KEY, userName)
                startActivity(userData)
            }
        }

        wifiBroadCastReceiver = WifiBroadCastReceiver()


        val list = (0..100).map {
            it.toString()
        }
//        binding?.listView?.adapter = object : ArrayAdapter<String>(this, R.layout.list_item, list) {
//            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//
//                val itemView = super.getView(position, convertView, parent)
//
//                val item = getItem(position)
//
//                val fieldText = itemView.findViewById<TextView>(R.id.tvItem)
//
//                fieldText.text = item
//
//                return itemView
//
//            }
//        }


        val adapter = MyCustomAdapter(list)

        binding?.listView?.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(this)
        }

    }

    override fun onResume() {
        super.onResume()

        val filter = IntentFilter().apply {
            addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        }

        registerReceiver(wifiBroadCastReceiver, filter)

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(wifiBroadCastReceiver)
    }


    companion object {
        const val USER_DATA_KEY = "USER"
    }
}