package com.ms.musicmanagement.shared.datasource.backend

import com.ms.musicmanagement.BuildConfig
import com.ms.musicmanagement.shared.datasource.backend.constant.LastFMApiParameters
import com.ms.musicmanagement.shared.model.backend.searchforartist.SearchForArtistResponse
import okhttp3.Interceptor
import okhttp3.Response

class LastFMBackendDataSourceImpl : BaseBackendDataSource(
    baseUrl = BuildConfig.BASE_URL,
    interceptor = LastFMHttpRequestInterceptor()
), LastFMBackendDataSource {

    private val lastFMRetrofitService = retrofit.create(LastFMRetrofitService::class.java)

    override suspend fun searchForArtist(searchQuery: String): SearchForArtistResponse {
        val response = lastFMRetrofitService.searchForArtist(searchQuery = searchQuery)
        return handleResponse(response)
    }

    private class LastFMHttpRequestInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val original = chain.request()
            val originalHttpUrl = original.url

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(LastFMApiParameters.Key.API_KEY, BuildConfig.LAST_FM_API_KEY)
                .addQueryParameter(
                    LastFMApiParameters.Key.FORMAT,
                    LastFMApiParameters.Value.FORMAT_JSON
                )
                .build()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder().url(url)

            val request = requestBuilder.build()
            return chain.proceed(request)
        }
    }

}
