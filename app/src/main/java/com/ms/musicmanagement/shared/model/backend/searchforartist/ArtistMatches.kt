package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.Artist

data class ArtistMatches(
    @SerializedName("artist")
    val artistsList: List<Artist>
)
