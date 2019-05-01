package com.codingblocks.workmanager

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scheduleOneTimeTask() {
        val workRequest =
            OneTimeWorkRequestBuilder<NetworkRequestWorker>()
                .setInitialDelay(10, TimeUnit.MINUTES)
                .build()

        WorkManager.getInstance().enqueue(workRequest)
    }

    fun scheduleRepeatingTask() {

        // These constrains allow the work to be executed only when :
        // 1. Device is connected to wifi
        // 2. Device is charging
        // 3. Device is not idle
        // 4. Device's storage isn't low
        val workConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(true)
            .setRequiresDeviceIdle(false)
            .setRequiresStorageNotLow(true)
            .build()

        val repeatingWorkRequest =
            PeriodicWorkRequestBuilder<NetworkRequestWorker>(
                1,
                TimeUnit.DAYS
            )
                .setConstraints(workConstraints)
                .build()

        //Cancelling an executed work
//        WorkManager.getInstance().cancelWorkById(repeatingWorkRequest.id)

        WorkManager.getInstance()
            .enqueue(repeatingWorkRequest)

    }

}
