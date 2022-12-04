package com.ms.musicmanagement.shared.model.backend.getalbuminfo

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Artist

data class Track(
    @SerializedName("@attr")
    val attr: TrackAttr,
    @SerializedName("artist")
    val artist: Artist,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("streamable")
    val streamable: Streamable,
    @SerializedName("url")
    val url: String
)
