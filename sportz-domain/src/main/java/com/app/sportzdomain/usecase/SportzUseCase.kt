package com.app.sportzdomain.usecase

import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import kotlinx.coroutines.flow.Flow

interface  SportzUseCase {
    /**
     * UseCase Method to fetch the sportz data from Data Layer
     */
    suspend fun execute(): Flow<ApiResponse<ResponseEntity>>
}