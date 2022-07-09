package com.example.heroapp.data.remote.apiservices

import com.example.heroapp.data.remote.models.HeroModel
import retrofit2.http.GET

interface HeroApiService {

    @GET("heroes")
    suspend fun fetchHeroes(): List<HeroModel>

}