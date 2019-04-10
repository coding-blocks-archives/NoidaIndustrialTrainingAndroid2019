package com.codingblocks.kotlin

//The constructor keyword for the primary constructor is optional
class NoteKt(var title: String, var time: String) {

    var date: String = ""

    constructor() : this("", "")

    constructor(noteTitle: String) : this(noteTitle, "")

    //Init block is similar to the constructor block in java
    init {
        date = "dkfdshf"
    }

    fun toUpperCase(): String {
        return title.toUpperCase()
    }

    //Single line function in kotlin
    fun toLowerCase() = title.toLowerCase()
}

class Article(
    var title: String,
    var content: String,
    var author: String = "",
    var date: String = ""
)

class People(
    var name: String,
    var dateOfBirth: String
)

fun test() {
    val article = Article("New Title", "Demo content")
}

const val KEY = "kjdhgdskfhg"