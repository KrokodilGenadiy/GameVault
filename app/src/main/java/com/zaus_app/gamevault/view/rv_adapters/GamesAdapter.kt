package com.zaus_app.moviefrumy_20.view.rv_adaptes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.databinding.GameItemBinding
import com.zaus_app.moviefrumy_2.view.rv_adaptes.GameDiffCallBack
import com.zaus_app.moviefrumy_20.view.rv_viewholders.GameViewHolder

class GamesAdapter(private val clickListener: OnItemClickListener) : PagingDataAdapter<Game, GameViewHolder>(
    GameDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding) {
           clickListener.click(getItem(it)!!.id)
        }
    }
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    interface OnItemClickListener {
        fun click(id: Int)
    }
}