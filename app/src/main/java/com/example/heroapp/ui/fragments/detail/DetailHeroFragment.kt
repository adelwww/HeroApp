package com.example.heroapp.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.heroapp.R
import com.example.heroapp.base.BaseFragment
import com.example.heroapp.databinding.FragmentDetailHeroBinding
import com.example.heroapp.ui.adapters.DetailHeroAdapter
import com.example.heroapp.ui.either.Either

class DetailHeroFragment : BaseFragment<DetailHeroViewModel, FragmentDetailHeroBinding>(
    R.layout.fragment_detail_hero
) {

    override val viewModel: DetailHeroViewModel by viewModels()
    override val binding by viewBinding(FragmentDetailHeroBinding::bind)
    private val args: DetailHeroFragmentArgs by navArgs()
    private val heroDetailAdapter = DetailHeroAdapter()

    override fun initialize() {
        setupAdapter()
    }

    private fun setupAdapter() = with(binding.recyclerDetailHero) {
        val linerLayoutManager = LinearLayoutManager(context)
        layoutManager = linerLayoutManager
        adapter = heroDetailAdapter
    }

    override fun setupSubscribe() {
        viewModel.fetchIdHeroes(args.id).observe(viewLifecycleOwner){
            when (it) {
                is Either.Left -> {
                    Log.e("son", it.value)
                }
                is Either.Right -> {
                    Log.e("son", it.toString())
                    heroDetailAdapter.submitList(it.value)
                }
            }
        }
    }
}
