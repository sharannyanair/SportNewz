package com.app.sportzdata.remote

import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.ResponseError
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

/**
 * Base class of Remote Data source
 * @param retrofit the object of Retrofit instance
 */
abstract class BaseDataSource constructor(
    private val retrofit: Retrofit
) {

    /**
     * Method to parse the Response of API Service
     * @param T the type of Response
     * @param request
     * @return ApiResponse<T> the result of the request with type T
     */
    suspend fun <T> getResponse(
        request: suspend () -> Response<T>,
        defaultErrorMessage: String
    ): ApiResponse<T> {
        return try {
            println("I'm working in thread ${Thread.currentThread().name}")
            val result = request.invoke()
            if (result.isSuccessful) {
                return ApiResponse.success(result.body())
            } else {
                val errorResponse = parseError(result)
                ApiResponse.error(
                    errorResponse?.statusMessage ?: defaultErrorMessage,
                    errorResponse
                )
            }
        } catch (e: Throwable) {
            ApiResponse.error("Unknown Error", null)
        }
    }

    /**
     * Method to convert the error response of API Service to requested type
     * @param response the response of requested api
     * @return the ResponseError of the request
     */
    private fun parseError(response: Response<*>): ResponseError? {
        val converter =
            retrofit.responseBodyConverter<ResponseError>(
                ResponseError::class.java,
                arrayOfNulls(0)
            )
        return try {
            response.errorBody()?.let {
                converter.convert(it)
            }
        } catch (e: IOException) {
            ResponseError()
        }
    }
}