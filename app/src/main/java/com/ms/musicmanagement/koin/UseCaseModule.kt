package com.ms.musicmanagement.koin

import com.ms.musicmanagement.screen.albumdetails.usecase.GetAlbumInfoUseCase
import com.ms.musicmanagement.screen.albumdetails.usecase.GetAlbumInfoUseCaseImpl
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCase
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCaseImpl
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCaseImpl
import com.ms.musicmanagement.shared.usecase.cachealbum.CacheAlbumUseCase
import com.ms.musicmanagement.shared.usecase.cachealbum.CacheAlbumUseCaseImpl
import com.ms.musicmanagement.shared.usecase.deletecachedalbum.DeleteAlbumUseCase
import com.ms.musicmanagement.shared.usecase.deletecachedalbum.DeleteAlbumUseCaseImpl
import org.koin.dsl.module

/**
 * This property is used to create UseCases and inject needed parameters
 * */
val useCaseModule = module {

    //region Artist Search
    factory<SearchForArtistUseCase> {
        SearchForArtistUseCaseImpl(
            lastFMRepository = get()
        )
    }
    //endregion
    //region Artist Top Albums
    factory<GetArtistTopAlbumsUseCase> {
        GetArtistTopAlbumsUseCaseImpl(
            lastFMRepository = get(), cacheRepository = get()
        )
    }
    //endregion

    //region Artist Top Albums
    factory<GetAlbumInfoUseCase> {
        GetAlbumInfoUseCaseImpl(
            lastFMRepository = get()
        )
    }
    //endregion

    //region Cache Albums
    factory<CacheAlbumUseCase> {
        CacheAlbumUseCaseImpl(
            cacheRepository = get()
        )
    }
    factory<DeleteAlbumUseCase> {
        DeleteAlbumUseCaseImpl(
            cacheRepository = get()
        )
    }
    //endregion
}
