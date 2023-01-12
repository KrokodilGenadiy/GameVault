package com.zaus_app.moviefrumy_2.data.paging

import androidx.paging.*
import com.zaus_app.gamevault.data.entity.Game
import com.zaus_app.gamevault.domain.Interactor
import com.zaus_app.gamevault.utils.Converter
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

private const val TMDB_STARTING_PAGE_INDEX = 1

class GamesPagingSource(
    private val query: String,
    private val interactor: Interactor
) : PagingSource<Int, Game>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        val pageIndex = params.key ?: TMDB_STARTING_PAGE_INDEX
        return try {
            val response = interactor.getGamesFromApi(query,pageIndex)
            val films = Converter.convertApiListToDtoList(response.body()?.results)
            val nextKey =
                if (films.isEmpty()) {
                    null
                } else {
                    pageIndex +1
                }
            LoadResult.Page(
                data = films,
                prevKey = if (pageIndex == TMDB_STARTING_PAGE_INDEX) null else pageIndex,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
