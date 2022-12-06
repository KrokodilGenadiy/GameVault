package com.zaus_app.moviefrumy_2.data.paging

import androidx.paging.PagingData
import com.zaus_app.gamevault.data.Game
import kotlinx.coroutines.flow.Flow

interface FilmsRemoteDataSource {
    fun getMovies(): Flow<PagingData<Game>>
}