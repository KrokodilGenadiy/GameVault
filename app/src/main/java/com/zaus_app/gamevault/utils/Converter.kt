package com.zaus_app.gamevault.utils

import com.zaus_app.gamevault.data.Game
import com.zaus_app.gamevault.data.RawgGame

object Converter {
    fun convertApiListToDtoList(list: List<RawgGame>?): List<Game> {
        val result = mutableListOf<Game>()
        list?.forEach {
            result.add(
                Game(
                    title = it.name,
                    background = it.backgroundImage
                )
            )
        }
        return result
    }
}