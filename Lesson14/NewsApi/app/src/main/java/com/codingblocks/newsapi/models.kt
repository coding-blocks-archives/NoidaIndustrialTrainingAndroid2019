package com.codingblocks.newsapi

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

class NewsResponse(
    val totalResults: Int,
    val articles: ArrayList<Article>
)

@Entity(tableName = "article")
class Article(
    @Embedded val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
    @PrimaryKey(autoGenerate = true) val _id: Long = 0
)

class Source(
    val id: String,
    val name: String
//    @ColumnInfo(name = "sourceUrl") val url: String,
//    @SerializedName("description") val sourceDescription: String
)

//Fragments/Menus
//FireBase/Ads (Videos)
//Services/Notifications
//Broadcasts
//Maps/Location
//Permissions/Sensors
