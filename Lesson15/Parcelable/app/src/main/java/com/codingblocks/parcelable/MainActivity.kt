package com.codingblocks.parcelable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    val note = Note("test", "test", 1, 11)

    val notesList = arrayListOf(note, note, note, note)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, NewActivity::class.java)

//        val gson = Gson()
//        val noteString = gson.toJson(note)
//        intent.putExtra("NOTE",noteString)

        intent.putExtra("NOTE", note)
        intent.putParcelableArrayListExtra("NOTES", notesList)

        //Serialization and Deserialization

        startActivity(intent)
    }
}
