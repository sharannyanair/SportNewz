package com.app.sportzdata.repository


import com.app.sportzdata.remote.ApiResponseDataSource
import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import com.app.sportzdomain.repository.SportzRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of CharsRepository
 * @param apiResponseDataSource the object of remote data source
 */
internal class SportzRepositoryImpl @Inject constructor(
    private val apiResponseDataSource: ApiResponseDataSource
) : SportzRepository {

    override fun fetchSportzData(): Flow<ApiResponse<ResponseEntity>> {
        return flow {
            val result = apiResponseDataSource.fetchSportsNews()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}