package com.codingblocks.parcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val note = intent.getParcelableExtra<Note>("NOTE")
        val notes = intent.getParcelableArrayListExtra<Note>("NOTES")
//        val noteString = intent.getStringExtra("NOTE")
//        val note = gson.fromJson(noteString, Note::class.java)

    }
}
