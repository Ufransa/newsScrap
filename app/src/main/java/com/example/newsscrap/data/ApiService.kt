package com.example.newsscrap.data

import retrofit2.http.GET
import retrofit2.http.Url
import retrofit2.Response

interface ApiService {
    @GET
    suspend fun getPokemonList(@Url url: String): Response<com.example.newsscrap.data.Response>
}