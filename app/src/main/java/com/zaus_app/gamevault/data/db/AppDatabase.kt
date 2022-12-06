package com.zaus_app.gamevault.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zaus_app.gamevault.data.dao.GamesDao
import com.zaus_app.gamevault.data.entity.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): GamesDao
}