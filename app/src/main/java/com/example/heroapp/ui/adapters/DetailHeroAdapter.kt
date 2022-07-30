package com.example.heroapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.heroapp.base.BaseDiffUtilItemCallback
import com.example.heroapp.data.remote.models.HeroModel
import com.example.heroapp.databinding.ItemDetailHeroBinding

class DetailHeroAdapter : ListAdapter<HeroModel, DetailHeroAdapter.DetailHeroViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHeroViewHolder {
        return DetailHeroViewHolder(
            ItemDetailHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: DetailHeroViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class DetailHeroViewHolder(
        private val binding: ItemDetailHeroBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(model: HeroModel) = with(binding) {
            binding.direNameTv.text = model.direName
            binding.durationTv.text = model.duration.toString()
            binding.leagueNameTv.text = model.leagueName
            binding.radiantNameTv.text = model.radiantName
        }
    }
}