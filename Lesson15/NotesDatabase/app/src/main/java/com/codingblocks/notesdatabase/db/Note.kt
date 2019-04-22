package com.codingblocks.notesdatabase.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    var title: String = "",
    var description: String = "",
    var date: String = "",
    var createdBy: String = "",
    @PrimaryKey(autoGenerate = true) var id: Long = 0
)