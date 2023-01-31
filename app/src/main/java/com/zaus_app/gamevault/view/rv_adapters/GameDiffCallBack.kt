package com.zaus_app.moviefrumy_2.view.rv_adaptes

import androidx.recyclerview.widget.DiffUtil
import com.zaus_app.gamevault.data.entity.Game

class GameDiffCallBack : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }
}
