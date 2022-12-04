package com.ms.musicmanagement.screen.albumdetails

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.ms.musicmanagement.screen.albumdetails.mapper.AlbumDetailsMapper
import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.screen.albumdetails.usecase.GetAlbumInfoUseCase
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.navigation.AlbumDetailsNavComposableDestination
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AlbumDetailsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?,
    private val getAlbumInfoUseCase: GetAlbumInfoUseCase
) : BaseViewModel(
    appContext = appContext
) {

    private val arguments: AlbumDetailsNavComposableDestination.AlbumDetailsArguments

    init {
        arguments = AppNavDestination.AlbumDetails.parseArguments(backStackEntryBundle)
        getTopAlbums()
    }


    private val _album: MutableStateFlow<AlbumDetailsUiModel?> = MutableStateFlow(null)
    val album = _album.asStateFlow()

    val albumName = arguments.albumName ?: ""

    //region Public methods
    //endregion

    //region Private methods
    private fun getTopAlbums() {
        viewModelScope.launch {
            try {
                _showLoading.value = true
                if (arguments.artistName != null && arguments.albumName != null) {
                    val albumDto = getAlbumInfoUseCase.invoke(
                        artistName = arguments.artistName,
                        albumName = arguments.albumName
                    )
                    _album.value = AlbumDetailsMapper.mapAlbumDtoToAlbumUiModel(albumDto)
                }
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }
    //endregion
}
