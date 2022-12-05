package com.zaus_app.gamevault.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name: String,
    val background: String,
    val rating: Double
) : Parcelable