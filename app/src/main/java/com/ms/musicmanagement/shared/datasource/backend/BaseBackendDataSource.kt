package com.ms.musicmanagement.shared.datasource.backend

import com.google.gson.Gson
import com.ms.musicmanagement.shared.model.backend.BaseResponse
import com.ms.musicmanagement.shared.model.backend.ErrorResponse
import com.ms.musicmanagement.shared.model.backend.exception.BackendBusinessException
import com.ms.musicmanagement.shared.model.backend.exception.ServerBackendException
import com.ms.musicmanagement.shared.model.backend.exception.UnknownBackendException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


open class BaseBackendDataSource(
    baseUrl: String,
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
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(baseUrl)
            .client(httpClient).build()

    protected fun <T : BaseResponse> handleResponse(
        response: Response<T>
    ): T {
        if (response.isSuccessful) {
            return requireNotNull(response.body())
        }
        throw generateException(response = response)
    }

    /*private fun generateBusinessException(
        errorCode: Int,
        errorMessage: String?
    ): BaseBusinessErrorException {
        /*return when (errorCode) {
            BusinessErrorNumber.OTHER.value -> {

            }
            else -> UnknownBusinessErrorException(errorMessage = errorMessage ?: "Unknown")
        }*/
        return UnknownBusinessErrorException(errorMessage = errorMessage ?: "Unknown")
    }*/

    private fun <T : BaseResponse> generateException(response: Response<T>): Exception {
        return when (response.code()) {
            in 500..504 -> {
                ServerBackendException(
                    errorCode = response.code(),
                    errorMessage = response.message()
                )
            }
            400 -> {
                mapErrorResponseToBackendBusinessExceptionIfApplication(response = response)
                    ?: UnknownBackendException(
                        errorCode = response.code(),
                        message = response.message()
                    )
            }
            else -> UnknownBackendException(
                errorCode = response.code(),
                message = response.message()
            )
        }
    }

    private fun mapErrorResponseToBackendBusinessExceptionIfApplication(
        response: Response<*>
    ): BackendBusinessException? {
        try {
            val errorResponseBody = response.errorBody() ?: return null
            val errorResponse = Gson().fromJson(
                errorResponseBody.charStream(),
                ErrorResponse::class.java
            )
            return BackendBusinessException(
                errorCode = errorResponse.errorCode ?: response.code(),
                errorMessage = errorResponse.errorMessage ?: response.message()
            )
        } catch (ex: Exception) {
            //ResponseBody have different
            return null
        }
    }
}
