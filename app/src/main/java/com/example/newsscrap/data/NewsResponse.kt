package com.example.newsscrap.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("results") var results: ArrayList<Results?>
)

data class Results(
    @SerializedName("id") var id: String? = null,
    @SerializedName("titulo") var titulo: String? = null,
    @SerializedName("descripcion") var descripcion: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("imagen") var imagen: String? = null

)