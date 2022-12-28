package com.zaus_app.gamevault.view.home_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.zaus_app.gamevault.App
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.domain.Interactor
import com.zaus_app.moviefrumy_2.data.paging.FilmsRemoteDataSource
import com.zaus_app.moviefrumy_2.data.paging.GamesRemoteDataSourceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HomeFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor
    private val gamesRemoteDataSource: FilmsRemoteDataSource

    init {
        App.instance.dagger.inject(this)
        gamesRemoteDataSource = GamesRemoteDataSourceImpl(interactor)
    }

    fun getMovies(): Flow<PagingData<Game>> {
        return gamesRemoteDataSource.getGames()
            .map { pagingData ->
                pagingData.map {
                    it
                }
            }
            .cachedIn(viewModelScope)
    }
}