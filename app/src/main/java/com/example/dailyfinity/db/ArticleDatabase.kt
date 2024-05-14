package com.example.dailyfinity.db

import androidx.room.Database
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.dailyfinity.models.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converters::class)
class ArticleDatabase {

}