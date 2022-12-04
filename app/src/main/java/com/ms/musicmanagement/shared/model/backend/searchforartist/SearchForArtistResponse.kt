package com.ms.musicmanagement.shared.model.backend.searchforartist

import com.google.gson.annotations.SerializedName
import com.ms.musicmanagement.shared.model.backend.BaseResponse

data class SearchForArtistResponse(
    @SerializedName("results")
    val results: Results
) : BaseResponse()
