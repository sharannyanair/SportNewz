package com.app.sportzdomain.data

/**
 * Generic class for holding success response, error response and loading status
 */
data class ApiResponse<out T>(
    val status: Status,
    val data: T?,
    val error: ResponseError?,
    val message: String?
) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(data: T?): ApiResponse<T> {
            return ApiResponse(Status.SUCCESS, data, null, null)
        }

        fun <T> error(message: String, error: ResponseError?): ApiResponse<T> {
            return ApiResponse(Status.ERROR, null, error, message)
        }
    }

    override fun toString(): String {
        return "Result(status=$status, data=$data, error=$error, message=$message)"
    }
}