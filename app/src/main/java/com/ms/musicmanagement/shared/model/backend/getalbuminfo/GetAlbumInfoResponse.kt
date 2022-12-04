package com.ms.musicmanagement.shared.model.backend.getalbuminfo

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.BaseResponse

data class GetAlbumInfoResponse(
    @SerializedName("album")
    val album: Album
) : BaseResponse()