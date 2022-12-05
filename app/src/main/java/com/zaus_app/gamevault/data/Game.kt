package com.zaus_app.gamevault.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val title: String,
    val background: String
) : Parcelable