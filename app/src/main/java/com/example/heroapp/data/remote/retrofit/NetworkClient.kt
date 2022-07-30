package com.example.heroapp.data.remote.retrofit

import com.example.heroapp.data.remote.apiservices.HeroApiService
import retrofit2.create
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttp: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideHeroesApiService() = provideRetrofit.create(HeroApiService::class.java)


}