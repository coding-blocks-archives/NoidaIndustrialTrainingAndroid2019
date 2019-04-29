package com.codingblocks.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                CHANNEL_ID_GENERAL,
                "My new channel",
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationChannel.description = "This is the only channel that you need to enable"
            notificationManager.createNotificationChannel(notificationChannel)
        }

        btnStartBackground.setOnClickListener {
            // We will start the background service here

//            val intent = Intent(this, BackgroundService::class.java)
//            intent.putExtra("KEY", "VALUE")
            val intent = Intent(this, BackgroundService::class.java)
            startService(intent)

        }

    }
}
