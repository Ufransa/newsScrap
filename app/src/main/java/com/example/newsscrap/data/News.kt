package com.example.newsscrap.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsEntity")
data class News(
    var titulo: String? = null,
    var descripcion: String? = null,
    var url: String? = null,
    var imagen: String? = null,
    val id: Long? = null,

    @PrimaryKey(autoGenerate = true)
    val idNew: Long? = null,

)