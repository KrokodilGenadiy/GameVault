package com.zaus_app.gamevault.utils

import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.data.entity.Genre
import com.zaus_app.gamevault.data.entity.RawgGame

object Converter {
    fun convertApiListToDtoList(list: List<RawgGame>?): List<Game> {
        val result = mutableListOf<Game>()
        list?.forEach {
            result.add(
                Game(
                    name = it.name,
                    background = it.backgroundImage,
                    genres = convertGenresToString(it.genres),
                    rating = it.rating
                )
            )
        }
        return result
    }

    fun convertGenresToString(genres: List<Genre>): String {
        var result = ""
        genres.forEach{
            result = "$result${it.name},"
        }
        return "Genres: "+result.dropLast(1)
    }
}