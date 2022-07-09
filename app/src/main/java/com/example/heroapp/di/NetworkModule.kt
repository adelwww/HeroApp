package com.example.heroapp.di

import com.example.heroapp.data.remote.retrofit.NetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideHeroesApiService(
        networkClient: NetworkClient
    ) = networkClient.provideHeroesApiService()

}