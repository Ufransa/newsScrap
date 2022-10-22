package com.example.newsscrap.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity")
    fun getAllNews() : MutableList<News?>

    @Insert
    fun addNew(news: News?)

    @Update
    fun updateNew(news: News?)

    @Delete
    fun deleteNew(news: News?)
}