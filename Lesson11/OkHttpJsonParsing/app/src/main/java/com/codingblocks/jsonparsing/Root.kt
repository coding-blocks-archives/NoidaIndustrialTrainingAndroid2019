package com.codingblocks.jsonparsing

class Root(
    val totalCount: Int,
    val incompleteResults: Boolean,
    val items: ArrayList<Item>
)

class Item(
    val id: Int,
    val login: String,
    val nodeId: String,
    val avatarUrl: String,
    val url: String,
    val htmlUrl: String
)