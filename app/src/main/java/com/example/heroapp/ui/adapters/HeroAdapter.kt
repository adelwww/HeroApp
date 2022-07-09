package com.example.heroapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.heroapp.base.BaseDiffUtilItemCallback
import com.example.heroapp.data.remote.models.HeroModel
import com.example.heroapp.databinding.ItemHeroBinding

class HeroAdapter : ListAdapter<HeroModel, HeroAdapter.HeroViewHolder>(
    BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        return HeroViewHolder(
            ItemHeroBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class HeroViewHolder(
        private val binding: ItemHeroBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(model: HeroModel) = with(binding) {
            nameTv.text = model.name
        }
    }
}