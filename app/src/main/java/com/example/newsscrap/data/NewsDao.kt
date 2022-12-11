package com.example.newsscrap.data

import androidx.room.*

@Dao
interface NewsDao {

    @Query("SELECT * FROM NewsEntity")
    fun getAllNews(): MutableList<News?>

    @Insert
    fun addNew(news: News?)

    @Update
    fun updateNew(news: News?)

    @Delete
    fun deleteNew(news: News?)
}