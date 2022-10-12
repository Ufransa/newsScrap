package com.example.newsscrap.data

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Response

interface ApiService {
    @GET
    suspend fun getNewsList(@Url url: String): Response<>
}