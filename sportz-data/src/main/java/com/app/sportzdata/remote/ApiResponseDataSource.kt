package com.app.sportzdata.remote

import com.app.sportzdata.service.DataApiService
import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * RemoteDataSource of Characters API service
 * @param apiService the object of api service
 */
class ApiResponseDataSource @Inject constructor(
    private val apiService: DataApiService, retrofit: Retrofit
) : BaseDataSource(retrofit) {

    /**
     * Method to fetch the characters from CharsRemoteDataSource
     * @return Outputs with list of Characters
     */
    suspend fun fetchSportsNews(): ApiResponse<ResponseEntity> {
        return getResponse(
            request = { apiService.getResults() },
            defaultErrorMessage = "Error fetching Characters"
        )
    }
}