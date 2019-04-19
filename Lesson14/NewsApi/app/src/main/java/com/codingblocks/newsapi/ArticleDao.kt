package com.codingblocks.newsapi

import android.arch.persistence.room.*

@Dao
interface ArticleDao {

    @Insert
    fun insertArticle(article: Article)

    @Insert
    fun insertArticleList(articles: List<Article>)

    @Delete
    fun deleteArticle(article: Article)

    @Delete
    fun deleteAll()

    @Update
    fun updateArticle(article: Article)

    @Query("SELECT * FROM article")
    fun getAllArticles(): List<Article>

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticlesBySourceId(id: String): List<Article>

}