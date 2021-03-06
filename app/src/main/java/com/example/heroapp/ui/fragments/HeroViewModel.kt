package com.example.heroapp.ui.fragments

import com.example.heroapp.base.BaseViewModel
import com.example.heroapp.data.remote.models.HeroModel
import com.example.heroapp.data.repositories.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HeroViewModel @Inject constructor(
    private val repository: HeroRepository
) : BaseViewModel() {

    fun fetchHeroes() = repository.fetchHeroes()

}
