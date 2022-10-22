package com.example.newsscrap.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface NewsApiService {
    @GET
    suspend fun getNewsList(@Url url: String): Response<List<News>>
}