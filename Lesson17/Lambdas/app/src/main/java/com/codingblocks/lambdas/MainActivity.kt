package com.codingblocks.lambdas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMain.setOnLongClickListener {
            Toast.makeText(this, "OnLongClick called", Toast.LENGTH_SHORT).show()
            //False means that you want to let the click event fall through to other listeners
            //True means that you want to consume the click event here
            false
        }

//        tvMain.setOnClickListener {
//            Toast.makeText(this,"OnClick called",Toast.LENGTH_SHORT).show()
//        }

        startCount(1000000000L) {
            tvMain.text = it
        }

        makeNetworkCallAndReturnList {

        }

    }

}
