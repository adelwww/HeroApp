package com.example.heroapp.data.remote.apiservices

import com.example.heroapp.data.remote.models.HeroModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroApiService {

    @GET("heroes")
    suspend fun fetchHeroes(): List<HeroModel>

    @GET("heroes/{hero_id}/matches")
    suspend fun fetchIdHeroes(
        @Path("hero_id") id : Int
    ): List<HeroModel>

}