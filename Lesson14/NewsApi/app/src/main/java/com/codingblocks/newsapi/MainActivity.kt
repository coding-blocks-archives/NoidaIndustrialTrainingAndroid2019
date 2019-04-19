package com.codingblocks.newsapi

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val migration_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            //Migrate to the new version
            database.execSQL("ALTER TABLE article ADD isRead INTEGER")
        }
    }

    private val migration_2_3 = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE article ADD readingTime TEXT")
        }

    }

    private val db by lazy {
        Room.databaseBuilder(
            this,
            ArticleDatabase::class.java,
            "appDatabase"
        )
            .addMigrations(migration_1_2, migration_2_3)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val articles = getArticles()

        if (articles.isEmpty()) {
            //Fetch articles from the network
            //Update the RecyclerView once the items are downloaded
            //Save them to the db
        } else {
            //Update the recyclerView
        }
    }

    fun storeArticles(articles: List<Article>) = db.getArticleDao().insertArticleList(articles)

    fun getArticles() = db.getArticleDao().getAllArticles()

}
