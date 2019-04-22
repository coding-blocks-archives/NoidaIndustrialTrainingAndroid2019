package com.codingblocks.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Note(
    val title: String,
    val desc: String,
    val id: Long,
    val timeOfCreation: Long
) : Parcelable