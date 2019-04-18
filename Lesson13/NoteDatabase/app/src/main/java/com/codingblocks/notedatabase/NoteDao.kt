package com.codingblocks.notedatabase

import android.arch.persistence.room.*

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

    @Insert
    fun insertMultipleNotes(vararg note: Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note_table WHERE timeOfCreation = :date")
    fun getNoteByCreationDate(date : Long) : Note

}