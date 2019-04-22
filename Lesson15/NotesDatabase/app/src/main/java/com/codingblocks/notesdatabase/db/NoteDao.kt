package com.codingblocks.notesdatabase.db

import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getAllNotes(): List<Note>

    @Query("SELECT * FROM note ORDER BY id DESC LIMIT :n")
    fun getLastNNotes(n: Int): List<Note>

    @Query("SELECT * FROM note WHERE id = :xyz")
    fun getNoteWithId(xyz: Long): Note

    @Update
    fun updateNote(note: Note)

    @Insert
    fun insertNote(note: Note)

    @Insert
    fun insertNotes(notes: List<Note>)

    @Delete
    fun deleteNote(note: Note)

    @Delete
    fun deleteNotes(notes: List<Note>)
}