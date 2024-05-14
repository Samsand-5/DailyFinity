package com.example.dailyfinity.db

import android.content.Context
import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dailyfinity.models.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class ArticleDatabase {

    abstract fun getArticleDao(): ArticleDao

    companion object{
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context): Any {

        }
    }
}