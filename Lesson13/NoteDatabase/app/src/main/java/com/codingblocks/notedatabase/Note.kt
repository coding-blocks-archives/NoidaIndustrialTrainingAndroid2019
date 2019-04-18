package com.codingblocks.notedatabase

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    var title: String,
    var description: String,
    @PrimaryKey val timeOfCreation: Long,
    var priority: Int
)

//You can use @Ignore to skip adding a column to your table schema