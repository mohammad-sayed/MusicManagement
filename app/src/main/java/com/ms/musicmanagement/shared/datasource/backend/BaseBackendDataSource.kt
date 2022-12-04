package com.ms.musicmanagement.shared.datasource.backend

import com.ms.musicmanagement.shared.model.backend.BaseResponse
import com.ms.musicmanagement.shared.model.backend.exception.ServerErrorException
import com.ms.musicmanagement.shared.model.backend.exception.UnknownBackendException
import com.ms.musicmanagement.shared.model.business.exception.BaseBusinessErrorException
import com.ms.musicmanagement.shared.model.business.exception.UnknownBusinessErrorException
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class BaseBackendDataSource(
    url: String,
    interceptor: Interceptor? = null
) {

    private val loggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private var httpClient: OkHttpClient

    init {
        val okHttpClientBuilder = OkHttpClient.Builder().addNetworkInterceptor(loggingInterceptor)
        interceptor?.let { okHttpClientBuilder.addInterceptor(it) }
        httpClient = okHttpClientBuilder.build()
    }

    protected val retrofit: Retrofit =
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(url)
            .client(httpClient).build()

    protected fun <T : BaseResponse> handleResponse(
        response: Response<T>
    ): T {
        if (response.isSuccessful) {
            val body = requireNotNull(response.body())
            if (body.errorCode != null) {
                throw generateBusinessException(
                    errorCode = body.errorCode,
                    errorMessage = body.errorMessage
                )
            }
            return body
        }
        throw generateException(response = response)
    }

    private fun generateBusinessException(
        errorCode: Int,
        errorMessage: String?
    ): BaseBusinessErrorException {
        /*return when (errorCode) {
            BusinessErrorNumber.OTHER.value -> {

            }
            else -> UnknownBusinessErrorException(errorMessage = errorMessage ?: "Unknown")
        }*/
        return UnknownBusinessErrorException(errorMessage = errorMessage ?: "Unknown")
    }

    private fun <T : BaseResponse> generateException(response: Response<T>): Exception {
        val message = if (response.body()?.errorCode != null) {
            response.body()?.errorMessage ?: response.message()
        } else {
            response.message()
        }
        return when (response.code()) {
            in 500..504 -> ServerErrorException(message)
            else -> UnknownBackendException(message)
        }
    }
}
