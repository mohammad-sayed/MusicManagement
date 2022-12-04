package com.ms.musicmanagement.shared.datasource.backend.constant

object LastFMApiParameters {

    const val API_KEY = "api_key"

    object Format {
        const val KEY = "format"
        const val VALUE_JSON = "json"
    }

    object Artist {
        private const val packageName = "artist"

        object Search {
            const val METHOD = "$packageName.search"
        }
    }
}
