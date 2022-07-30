package com.example.heroapp.ui.fragments.detail

import com.example.heroapp.base.BaseViewModel
import com.example.heroapp.data.repositories.HeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailHeroViewModel @Inject constructor(
    private val repository: HeroRepository
) : BaseViewModel() {

    fun fetchIdHeroes(id: Int) = repository.fetchIdHeroes(id)

}