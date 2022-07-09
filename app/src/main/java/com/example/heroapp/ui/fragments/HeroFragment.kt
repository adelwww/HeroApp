package com.example.heroapp.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroapp.R
import com.example.heroapp.base.BaseFragment
import com.example.heroapp.databinding.FragmentHeroBinding
import com.example.heroapp.ui.adapters.HeroAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroFragment : BaseFragment<HeroViewModel, FragmentHeroBinding>(
    R.layout.fragment_hero
) {

    override val viewModel: HeroViewModel by viewModels()
    override val binding by viewBinding(FragmentHeroBinding::bind)
    private val heroAdapter = HeroAdapter()

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = heroAdapter
    }

    override fun setupSubscribe() {
        viewModel.heroesState.collectUIState(
            error = {
                Log.e("son", it)
            },
            success = {
                heroAdapter.submitList(it)
            }
        )
    }
}