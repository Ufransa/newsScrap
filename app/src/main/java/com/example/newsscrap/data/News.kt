package com.example.newsscrap.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsEntity")
data class News(
    val id: Int? = null,
    var titulo: String? = null,
    var descripcion: String? = null,
    var url: String? = null,
    var imagen: String? = null,


    @PrimaryKey(autoGenerate = true)
    val idNew: Int? = null,

    )