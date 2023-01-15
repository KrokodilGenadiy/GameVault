package com.zaus_app.gamevault.data

import com.zaus_app.gamevault.data.entity.GameDetails
import com.zaus_app.gamevault.data.entity.RawgGame
import com.zaus_app.gamevault.data.entity.RawgResultsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RawgApi {
    @GET("games")
    suspend fun getGames(
        @Query("search") query: String,
        @Query("key") apiKey: String,
        @Query("page") page: Int
    ): Response<RawgResultsDto>

    @GET("games/{id}")
    suspend fun getGameDetails(
        @Path("id") id: Int,
        @Query("key") apiKey: String,
    ): Response<GameDetails>
}
