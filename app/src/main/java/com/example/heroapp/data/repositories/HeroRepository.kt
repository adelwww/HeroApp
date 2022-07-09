package com.example.heroapp.data.repositories

import com.example.heroapp.base.BaseRepository
import com.example.heroapp.data.remote.apiservices.HeroApiService
import javax.inject.Inject

class HeroRepository @Inject constructor(
    private val service: HeroApiService
) : BaseRepository() {

    fun fetchHeroes() = doRequest {
        service.fetchHeroes()
    }
}
