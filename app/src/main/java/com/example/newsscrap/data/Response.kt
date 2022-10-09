package com.example.newsscrap.data

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("results") var results: ArrayList<Results?>
)

data class Results(
    @SerializedName("title") var title: String? = null,
    @SerializedName("body") var body: String? = null
)