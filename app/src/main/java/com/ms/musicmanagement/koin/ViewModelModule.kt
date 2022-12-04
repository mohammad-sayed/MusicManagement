package com.ms.musicmanagement.koin

import com.ms.musicmanagement.screen.artistsearch.ArtistSearchViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This property is used to create ViewModels and inject needed parameters
 * */
val viewModelModule = module {

    viewModel {
        ArtistSearchViewModel(appContext = androidApplication())
    }

}
