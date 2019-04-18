package com.codingblocks.notedatabase

import android.arch.persistence.room.Room
import android.os.Bundle
import android.support.annotation.Keep
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val db: NoteDatabase by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "note_database"
        )
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        swipeToRefresh.setOnRefreshListener {
//
//            swipeToRefresh.isRefreshing = false
//
//        }

        fabAdd.setOnClickListener {
            showCustomAlert()
        }
    }

    @Keep
    private fun showCustomAlert() {

        val dialogView = layoutInflater.inflate(
            R.layout.view_dialog,
            null,
            false
        )
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Hello from an Alert Dialog!")
            .setView(dialogView)
            .setCancelable(false)
            .setPositiveButton("Save") { dialog, which ->
                val title = dialogView.etTitle.text.toString()
                val desc = dialogView.etDesc.text.toString()
                val priority = dialogView.etPriority.text.toString().toInt()
                val timeOfCreation = System.currentTimeMillis()

                val note = Note(title, desc, timeOfCreation, priority)

                db.getNoteDao().insertNote(note)

                //Save this note to the database

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }
            .create()

        alertDialog.show()
    }
}
