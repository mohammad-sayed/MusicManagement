package com.ms.musicmanagement.shared.model.backend.getartisttopalbums

import com.google.gson.annotations.SerializedName

data class Attr(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("page")
    val page: String,
    @SerializedName("perPage")
    val perPage: String,
    @SerializedName("total")
    val total: String,
    @SerializedName("totalPages")
    val totalPages: String
)
