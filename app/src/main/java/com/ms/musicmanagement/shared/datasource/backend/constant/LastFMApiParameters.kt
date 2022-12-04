package com.ms.musicmanagement.shared.datasource.backend.constant

object LastFMApiParameters {


    object Key {
        const val API_KEY = "api_key"
        const val METHOD = "method"
        const val FORMAT = "format"
        const val ARTIST = "artist"
        const val ALBUM = "album"
    }

    object Value {
        const val FORMAT_JSON = "json"

        object Artist {
            private const val packageName = "artist"
            const val METHOD_SEARCH = "$packageName.search"
            const val METHOD_GET_TOP_ALBUMS = "$packageName.getTopAlbums"
        }

        object Album {
            private const val packageName = "album"
            const val METHOD_GET_INFO = "$packageName.getInfo"
        }
    }
}
