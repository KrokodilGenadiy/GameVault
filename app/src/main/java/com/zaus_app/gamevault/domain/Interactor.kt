package com.zaus_app.gamevault.domain

import com.zaus_app.gamevault.data.RawgApi
import com.zaus_app.gamevault.data.entity.GameDetails
import com.zaus_app.gamevault.data.entity.RawgGame
import com.zaus_app.gamevault.data.entity.RawgResultsDto
import com.zaus_app.moviefrumy_2.data.API
import retrofit2.Response

class Interactor ( private val retrofitService: RawgApi) {
    suspend fun getGamesFromApi(query:String, page: Int): Response<RawgResultsDto> {
        return retrofitService.getGames(query, API.KEY, page)
    }

    suspend fun getGameDetails(id: Int): Response<GameDetails> {
        return retrofitService.getGameDetails(id, API.KEY)
    }
}