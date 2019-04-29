package com.codingblocks.services

import android.app.IntentService
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

//1. It runs in the background thread by default
//2.
class BackgroundIntentService : IntentService("BackgroundIntentService") {

    override fun onCreate() {
        super.onCreate()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "onDestroy called")
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.e("TAG", "IntentService started")

    }
}