package com.example.newsscrap.data

data class News(
    var results: List<Results?>
)

data class Results(
    var titulo: String,
    var descripcion: String,
    var url: String,
    var imagen: String,
    val id: String,

    //TODO 3: Retrofit
)