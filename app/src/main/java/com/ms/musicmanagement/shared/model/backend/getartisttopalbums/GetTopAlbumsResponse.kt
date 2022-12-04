package com.ms.musicmanagement.shared.model.backend.getartisttopalbums

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.BaseResponse

data class GetTopAlbumsResponse(
    @SerializedName("topalbums")
    val topAlbums: TopAlbums
) : BaseResponse()
