package com.example.heroapp.ui.fragments

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroapp.R
import com.example.heroapp.base.BaseFragment
import com.example.heroapp.databinding.FragmentHeroBinding
import com.example.heroapp.ui.adapters.HeroAdapter
import com.example.heroapp.ui.either.Either
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroFragment : BaseFragment<HeroViewModel, FragmentHeroBinding>(
    R.layout.fragment_hero
) {

    override val viewModel: HeroViewModel by viewModels()
    override val binding by viewBinding(FragmentHeroBinding::bind)
    private val heroAdapter = HeroAdapter(this::onItemClick)

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recycler) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = heroAdapter
    }

    override fun setupSubscribe() {
        viewModel.fetchHeroes().observe(viewLifecycleOwner){
            when (it) {
                is Either.Left -> {
                    Log.e("son", it.value)
                }
                is Either.Right -> {
                    Log.e("son", it.toString())
                    heroAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id:Int){
        findNavController().navigate(
            HeroFragmentDirections.actionHeroFragmentToDetailHeroFragment(id)
        )
    }
}