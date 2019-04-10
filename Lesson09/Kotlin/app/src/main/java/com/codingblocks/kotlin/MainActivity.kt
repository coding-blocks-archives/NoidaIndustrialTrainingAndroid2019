package com.codingblocks.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var count = 0
    var note = NoteKt("Test", "27-01-2019")
    val noteFinal = NoteKt("new title")

    fun doSomethingWithInput(str: String) {
        //Do something
    }

    private fun getContentFromUrl(inputUrl: String): String? {
        //Getting things from the URL
        return null
    }

    override fun onClick(v: View?) {
        val id = v?.id
        note.toLowerCase()
        count++
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = getContentFromUrl("xhdshj")

        btnTest.setOnClickListener {
            val key = savedInstanceState?.getString("KEY")
            val key2 = savedInstanceState?.getString("KEY2")
        }

        btnTest.setOnClickListener {
            thread {
                //Do something
                runOnUiThread {
                    //Show something on the UI
                }
            }
        }

    }
}