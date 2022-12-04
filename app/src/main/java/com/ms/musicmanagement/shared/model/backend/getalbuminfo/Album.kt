package com.ms.musicmanagement.shared.model.backend.getalbuminfo

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Image

data class Album(
    @SerializedName("artist")
    val artist: String,
    @SerializedName("image")
    val imageResolutions: List<Image>,
    @SerializedName("listeners")
    val listeners: String,
    @SerializedName("mbid")
    val mbid: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("playcount")
    val playCount: String,
    @SerializedName("tags")
    val tags: Tags,
    @SerializedName("tracks")
    val tracks: Tracks,
    @SerializedName("url")
    val url: String,
    @SerializedName("wiki")
    val wiki: Wiki
)
