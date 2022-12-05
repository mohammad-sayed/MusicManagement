package com.ms.musicmanagement.koin

import android.os.Bundle
import com.ms.musicmanagement.screen.albumdetails.AlbumDetailsViewModel
import com.ms.musicmanagement.screen.artistsearch.ArtistSearchViewModel
import com.ms.musicmanagement.screen.artisttopalbums.ArtistTopAlbumsViewModel
import com.ms.musicmanagement.screen.savedalbums.SavedAlbumsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This property is used to create ViewModels and inject needed parameters
 * */
val viewModelModule = module {

    viewModel {
        SavedAlbumsViewModel(
            appContext = androidApplication(),
            getCachedAlbumsUseCase = get(),
            deleteAlbumUseCase = get()
        )
    }

    viewModel {
        ArtistSearchViewModel(
            appContext = androidApplication(),
            searchForArtistUseCase = get()
        )
    }
    viewModel { (bundle: Bundle?) ->
        ArtistTopAlbumsViewModel(
            appContext = androidApplication(),
            backStackEntryBundle = bundle,
            getArtistTopAlbumsUseCase = get(),
            cacheAlbumUseCase = get(),
            deleteAlbumUseCase = get()
        )
    }

    viewModel { (bundle: Bundle?) ->
        AlbumDetailsViewModel(
            appContext = androidApplication(),
            backStackEntryBundle = bundle,
            getAlbumInfoUseCase = get(),
            getCachedAlbumUseCase = get()
        )
    }
}
