package com.example.dailyfinity.db

import androidx.room.TypeConverter
import com.example.dailyfinity.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }
}