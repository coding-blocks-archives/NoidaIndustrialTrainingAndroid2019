package com.codingblocks.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.support.v4.app.NotificationCompat
import android.util.Log
import kotlin.concurrent.thread

//A service runs on the main thread by default
class BackgroundService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "onCreate called")
        val notification = NotificationCompat.Builder(this, CHANNEL_ID_GENERAL)
            .setContentTitle("Hello I'm a notification")
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentText("Some description here")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        startForeground(12345, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        thread {
            //Long running task goes here

            //Stop the foreground service and remove the notification
//            stopForeground(true)
        }

        Log.e("TAG", "onStartCommand Called")

//

        return START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy Called")
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}