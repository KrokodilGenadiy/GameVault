package com.zaus_app.moviefrumy_20.view.rv_viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.databinding.GameItemBinding

class GameViewHolder(binding: GameItemBinding, clickAtPosition: () -> Unit) : RecyclerView.ViewHolder(binding.root) {

    private val title = binding.name
    private val poster = binding.gameBackground
    private val genres = binding.genres
    private val rating = binding.rating

    init {
        binding.root.setOnClickListener {
            clickAtPosition()
        }
    }

    fun bind(game: Game) {
        title.text = game.name
        Glide.with(itemView)
            .load(game.background)
            .centerCrop()
            .into(poster)
        genres.text = game.genres
        rating.text = "Rating: "+game.rating
    }

}