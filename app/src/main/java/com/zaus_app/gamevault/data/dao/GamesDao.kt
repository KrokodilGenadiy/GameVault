package com.zaus_app.gamevault.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zaus_app.gamevault.data.entity.Game


@Dao
interface GamesDao {
    @Query("SELECT * FROM favorite_games")
    fun getCachedGames(): List<Game>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGame(game: Game)
}
