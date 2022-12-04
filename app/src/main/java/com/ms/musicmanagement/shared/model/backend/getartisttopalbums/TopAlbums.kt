package com.ms.musicmanagement.shared.model.backend.getartisttopalbums

import com.google.gson.annotations.SerializedName

data class TopAlbums(
    @SerializedName("@attr")
    val attr: Attr,
    @SerializedName("album")
    val albums: List<Album>
)
