package com.ms.musicmanagement.koin

import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCase
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCaseImpl
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCase
import com.ms.musicmanagement.screen.artisttopalbums.usecase.getartisttopalbums.GetArtistTopAlbumsUseCaseImpl
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
            lastFMRepository = get()
        )
    }
    //endregion
}
