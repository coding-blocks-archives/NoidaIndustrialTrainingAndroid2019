package com.codingblocks.broadcastreveivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class PowerStateReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        //UI thread!
        Log.e("TAG", intent?.action)
    }

}