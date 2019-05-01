package com.codingblocks.alarms

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import java.util.*

class MainActivity : AppCompatActivity() {

    val alarmManager by lazy {
        getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setRepeatingRTC() {
        val intentToStartMainActivity = Intent(
            this,
            MainActivity::class.java
        )

        val pi = PendingIntent.getActivity(
            this,
            12345,
            intentToStartMainActivity,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val calendar = Calendar.getInstance()

        //You will need to call this to update the calendar to the current time
//        calendar.timeInMillis = System.currentTimeMillis()

        calendar.set(2020, 1, 16, 18, 0)

        alarmManager.setRepeating(
            AlarmManager.RTC,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY * 7,
            pi
        )

        //This cancels the alarm scheduled above
//        alarmManager.cancel(pi)

    }

    fun setNonRepeatingRTC() {

        val intentToStartMainActivity = Intent(
            this,
            MainActivity::class.java
        )

        val pi = PendingIntent.getActivity(
            this,
            12345,
            intentToStartMainActivity,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val calendar = Calendar.getInstance()

        //You will need to call this to update the calendar to the current time
//        calendar.timeInMillis = System.currentTimeMillis()

        calendar.set(2020, 1, 16, 18, 0)

        //Set an alarm for 16th Jan 2020, 6pm
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            //triggerTime,
            calendar.timeInMillis,
            pi
        )

    }

    fun setNonRepeatingElapsed() {
        //Set an alarm, 30 mins from now

        val intentToStartMainActivity = Intent(
            this,
            MainActivity::class.java
        )

        val pi = PendingIntent.getActivity(
            this,
            12345,
            intentToStartMainActivity,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val intentForService = Intent(
            this,
            MyService::class.java
        )

        intentForService.putExtra("KEY", "VALUE")

        val piService = PendingIntent.getService(
            this,
            123456,
            intentForService,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.set(
            AlarmManager.ELAPSED_REALTIME,
            AlarmManager.INTERVAL_HALF_HOUR,
            piService
        )

        alarmManager.setExact(
            AlarmManager.ELAPSED_REALTIME,
            AlarmManager.INTERVAL_HALF_HOUR,
            piService
        )

    }

    fun setRepeatingElapsed() {

        val intentToStartMainActivity = Intent(
            this,
            MainActivity::class.java
        )

        val pi = PendingIntent.getActivity(
            this,
            12345,
            intentToStartMainActivity,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        //Delivers and repeats the alarm at the fixed specified time
        alarmManager.setRepeating(
            AlarmManager.ELAPSED_REALTIME,
            AlarmManager.INTERVAL_HALF_HOUR,
            AlarmManager.INTERVAL_HOUR,
            pi
        )

        //This adjusts the delivery time accordingly
        alarmManager.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME,
            AlarmManager.INTERVAL_HALF_HOUR,
            AlarmManager.INTERVAL_HOUR,
            pi
        )

    }

}
