package com.codingblocks.notesfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingblocks.notesdatabase.NoteAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_dialog.view.*

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<Note?>()

    private val noteAdapter = NoteAdapter(notes)

    private val dialogView by lazy {
        layoutInflater.inflate(R.layout.layout_dialog, null, false)
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
//                notes.add(0, note)
//                noteAdapter.notifyItemInserted(0)
                saveNoteToFirebaseDatabase(note)
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

        rvNotes.adapter = noteAdapter

        fabAddNote.setOnClickListener {
            noteAlert.show()
        }

        FirebaseDatabase.getInstance()
            .reference
//            .child("test")
            .addChildEventListener(object : ChildEventListener {

                override fun onCancelled(dbErr: DatabaseError) = dbErr.toException().printStackTrace()

                override fun onChildMoved(ds: DataSnapshot, key: String?) {

                }

                override fun onChildChanged(ds: DataSnapshot, key: String?) {
                    //add the updated child to your arrayList
                    //notify the adapter
                    val updatedNote = ds.getValue(Note::class.java)

                }

                override fun onChildAdded(ds: DataSnapshot, key: String?) {
                    //add the received child to your arrayList
                    //notify the adapter
                    val note = ds.getValue(Note::class.java)
                    notes.add(0, note)
                    noteAdapter.notifyItemInserted(0)
                }

                override fun onChildRemoved(ds: DataSnapshot) {
                    //remove the received child from your arraylist
                    //notify the adapter
                    val deletedNote = ds.getValue(Note::class.java)
                    notes.remove(deletedNote)
                }
            })

        //This is not realtime, only gives you the data snapshot
        // once the listener is attached
        FirebaseDatabase.getInstance()
            .reference
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(p0: DataSnapshot) {

                }

                override fun onCancelled(p0: DatabaseError) {

                }

            })

        FirebaseDatabase.getInstance()
            .reference
            .child("test")
            .addValueEventListener(object : ValueEventListener {
                override fun onCancelled(dbErr: DatabaseError) {

                }

                override fun onDataChange(ds: DataSnapshot) {
                    ds.children.forEach {
                        val note = it.getValue(Note::class.java)
                    }

//                    FirebaseDatabase.getInstance().reference.removeEventListener(this)
                }

            })
    }

    private fun saveNoteToFirebaseDatabase(note: Note) {
        //Write code for database
        val firebaseDatabase = FirebaseDatabase.getInstance()

        //Any read/write will have to happen on an DatabaseReference object
        val rootDatabaseReference = firebaseDatabase.reference

        //Push automatically generated a unique ID for you
        val childReference = rootDatabaseReference.push()

        childReference.setValue(note)

//        FirebaseDatabase.getInstance().reference.push().setValue(note)
    }
}
