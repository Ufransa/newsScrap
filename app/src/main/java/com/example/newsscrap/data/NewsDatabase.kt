package com.example.newsscrap.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [News::class],
    version = 1
)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun NewsDao(): NewsDao
}