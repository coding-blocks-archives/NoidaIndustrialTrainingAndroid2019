package com.codingblocks.networkingokhttp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://api.github.com/search/users?q="

        val client = OkHttpClient()

//        val student = Student.Builder()
//            .setAge("23")
//            .setBatch("Android")
//            .setName("Harshit")
//            .build()
//        val studentKt = StudentKt(age = "12", name = "Harshit")

        val request = Request.Builder()
            .url(url)
            .build()

        //If any interface has a single method, while implementing it,
        //you can convert it to a lambda
//        tvResult.setOnClickListener(object : View.OnClickListener{
//
//            override fun onClick(v: View?) {
//
//            }
//
//        })
//
//        tvResult.setOnClickListener {view ->
//            view.id
//        }

        //Execute the request inside a thread
//        thread {
//            val response = client.newCall(request).execute()
//            val responseString = response.body()?.string()
//
//            runOnUiThread {
//                tvResult.text = responseString
//            }
//        }

        //Enqueue the request
        val call = client.newCall(request)

        val maxRetries = 4

        call.enqueue(object : Callback {

            //Only retry a maximum of 4 times if the request errorred out
            var retries = 0

            override fun onFailure(call: Call, e: IOException) {
                if (++retries < maxRetries) {
                    call.cancel()
                    call.enqueue(this)
                }
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val result = response.body()?.string()
                runOnUiThread {
                    tvResult.text = result
                }
            }
        })
    }

//    class NetworkTask : AsyncTask<URL, Void, String>() {
//
//        override fun doInBackground(vararg params: URL?): String {
//
//        }
//
//    }

}
