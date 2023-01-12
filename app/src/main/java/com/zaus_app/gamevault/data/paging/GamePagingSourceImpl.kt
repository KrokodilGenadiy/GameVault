package com.zaus_app.gamevault.data.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.domain.Interactor
import com.zaus_app.moviefrumy_2.data.paging.GamesPagingSource
import kotlinx.coroutines.flow.Flow

class GamesRemoteDataSourceImpl(
    private val query: String,
    private val interactor: Interactor) {
    fun getMovies(): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                GamesPagingSource(query,interactor)
            }
        ).flow
    }
    companion object {
        const val NETWORK_PAGE_SIZE = 30
    }
}