package com.example.testing.task1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.widget.Toast

//add broadCastReceiver

class WifiBroadCastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            WifiManager.WIFI_STATE_CHANGED_ACTION -> {
                val wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, -1)
                when (wifiState) {
                    WifiManager.WIFI_STATE_ENABLED -> Toast.makeText(
                        context,
                        "Enabled Wifi",
                        Toast.LENGTH_SHORT
                    ).show()

                    WifiManager.WIFI_STATE_DISABLED -> Toast.makeText(
                        context, "Disabled WIFI",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}