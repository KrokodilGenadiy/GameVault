package com.zaus_app.gamevault.data.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "favorite_games", indices = [Index(value = ["name"], unique = true)])
data class Game(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "background_path") val background: String,
    @ColumnInfo(name = "genres") val genres: String,
    @ColumnInfo(name = "rating")val rating: Double
) : Parcelable