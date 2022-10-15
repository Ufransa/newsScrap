package com.example.newsscrap.data

data class News(
    var titulo: String? = null,
    var descripcion: String? = null,
    var url: String? = null,
    var imagen: String? = null,
    val id: Long? = null,

    //TODO 3: Retrofit
)