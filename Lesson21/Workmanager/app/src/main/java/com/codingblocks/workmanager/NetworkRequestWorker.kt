package com.codingblocks.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class NetworkRequestWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {

    //This runs in the background thread by default
    override fun doWork(): Result {

        //Make the OKHttp call

        //Save the updated data into Room Db

        return Result.success()
    }

}