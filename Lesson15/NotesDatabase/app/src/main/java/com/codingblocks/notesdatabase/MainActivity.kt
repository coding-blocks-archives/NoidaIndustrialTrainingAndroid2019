package com.codingblocks.notesdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<Note>()

    private val noteAdapter = NoteAdapter(notes)

    private val dialogView by lazy {
        layoutInflater.inflate(R.layout.layout_dialog, null, false)
    }

    val db by lazy {
        Room.databaseBuilder(
            this,
            NoteDatabase::class.java,
            "notes_db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    private val noteAlert by lazy {
        AlertDialog.Builder(this)
            .setTitle("Enter the note here")
            .setView(dialogView)
            .setPositiveButton("Save") { dialog, _ ->
                val note = Note(
                    dialogView.etTitle.text.toString(),
                    dialogView.etDescription.text.toString(),
                    System.currentTimeMillis().toString()
                )

                notes.add(0, note)
                noteAdapter.notifyItemInserted(0)

                saveNoteToDatabase(note)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNotes.layoutManager = LinearLayoutManager(this)
        notes.addAll(db.getNoteDao().getAllNotes())
        rvNotes.adapter = noteAdapter

        fabAddNote.setOnClickListener {
            noteAlert.show()
        }

    }

    private fun saveNoteToDatabase(note: Note) {
        //Write code for database
        db.getNoteDao().insertNote(note)
    }
}
