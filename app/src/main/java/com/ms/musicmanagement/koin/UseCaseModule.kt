package com.ms.musicmanagement.koin

import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCase
import com.ms.musicmanagement.screen.artistsearch.usecase.searchforartist.SearchForArtistUseCaseImpl
import org.koin.dsl.module

/**
 * This property is used to create UseCases and inject needed parameters
 * */
val useCaseModule = module {

    //region Artist Search
    factory<SearchForArtistUseCase> { SearchForArtistUseCaseImpl() }
    //endregion
}
