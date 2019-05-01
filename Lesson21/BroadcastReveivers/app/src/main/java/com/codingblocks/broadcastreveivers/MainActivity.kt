package com.codingblocks.broadcastreveivers

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // For android oreo and above, registering Broadcast Receivers from the Manifest
        // is not allowed. If you do so, your broadcast's onReceive won't be called
        // To fix this, you can register your broadcast, on runTime as shown in the code below
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED)
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)

        val powerReceiver = PowerStateReceiver()

        //This broadcast will be automatically unregistered once the app closes
        registerReceiver(powerReceiver, intentFilter)


        //Send a custom broadcast
        val intent = Intent("xyz")
        sendBroadcast(intent)
    }
}
