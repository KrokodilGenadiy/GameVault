package com.zaus_app.gamevault.data

import com.google.gson.annotations.SerializedName

data class RawgResultsDto (
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<RawgGame>
)