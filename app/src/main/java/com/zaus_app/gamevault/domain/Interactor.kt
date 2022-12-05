package com.zaus_app.gamevault.domain

import com.zaus_app.gamevault.data.RawgApi
import com.zaus_app.gamevault.data.RawgResultsDto
import com.zaus_app.moviefrumy_2.data.API
import retrofit2.Response

class Interactor (private val retrofitService: RawgApi) {
    suspend fun getGamesFromApi(page: Int): Response<RawgResultsDto> {
        return retrofitService.getGames(API.KEY, page)
    }
}