package com.ms.musicmanagement.screen.albumdetails

import android.app.Application
import android.os.Bundle
import androidx.lifecycle.viewModelScope
import com.ms.musicmanagement.screen.albumdetails.mapper.AlbumDetailsMapper
import com.ms.musicmanagement.screen.albumdetails.uimodel.AlbumDetailsUiModel
import com.ms.musicmanagement.screen.albumdetails.usecase.getalbuminfo.GetAlbumInfoUseCase
import com.ms.musicmanagement.screen.albumdetails.usecase.getcachedalbum.GetCachedAlbumUseCase
import com.ms.musicmanagement.shared.base.BaseViewModel
import com.ms.musicmanagement.shared.model.business.dto.AlbumDto
import com.ms.musicmanagement.shared.navigation.AlbumDetailsNavComposableDestination
import com.ms.musicmanagement.shared.navigation.AppNavDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class AlbumDetailsViewModel(
    appContext: Application,
    backStackEntryBundle: Bundle?,
    private val getAlbumInfoUseCase: GetAlbumInfoUseCase,
    private val getCachedAlbumUseCase: GetCachedAlbumUseCase
) : BaseViewModel(
    appContext = appContext
) {

    private val arguments: AlbumDetailsNavComposableDestination.AlbumDetailsArguments

    init {
        arguments = AppNavDestination.AlbumDetails.parseArguments(backStackEntryBundle)
        getAlbumInfo()
    }


    private val _album: MutableStateFlow<AlbumDetailsUiModel?> = MutableStateFlow(null)
    val album = _album.asStateFlow()

    val albumName = arguments.albumName ?: ""

    //region Public methods
    //endregion

    //region Private methods
    private fun getAlbumInfo() {
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
            } catch (ex: UnknownHostException) {
                //Internet connection error
                getCachedAlbum()
            } catch (ex: Exception) {
                handleException(ex)
            } finally {
                _showLoading.value = false
            }
        }
    }

    private suspend fun getCachedAlbum() {
        try {
            val albumDto = getCachedAlbumUseCase.invoke(albumName = albumName)
            _album.value = AlbumDetailsMapper.mapAlbumDtoToAlbumUiModel(albumDto)
        } catch (ex: Exception) {
            handleException(ex)
        }
    }
    //endregion
}
