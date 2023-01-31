package com.zaus_app.gamevault.view.home_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.zaus_app.gamevault.App
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.data.paging.GamesRemoteDataSourceImpl
import com.zaus_app.gamevault.domain.Interactor
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class HomeFragmentViewModel: ViewModel() {
    @Inject
    lateinit var interactor: Interactor
    private val _query = MutableStateFlow("")
    private val query: StateFlow<String> = _query.asStateFlow()
    val games: StateFlow<PagingData<Game>>

    init {
        App.instance.dagger.inject(this)
        games = query.flatMapLatest {
            getGames()
        }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
    }

    private fun getGames(): Flow<PagingData<Game>> {
        return GamesRemoteDataSourceImpl(query.value,interactor).getMovies()
            .map { pagingData ->
                pagingData.map {
                    it
                }
            }
            .cachedIn(viewModelScope)
    }

    fun setQuery(query: String) {
        _query.tryEmit(query)
    }
}