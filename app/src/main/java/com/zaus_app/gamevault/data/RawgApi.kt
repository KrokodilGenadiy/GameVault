package com.zaus_app.gamevault.data

import com.zaus_app.gamevault.data.entity.RawgResultsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getGames(
        @Query("key") apiKey: String,
        @Query("page") page: Int
    ): Response<RawgResultsDto>
}
