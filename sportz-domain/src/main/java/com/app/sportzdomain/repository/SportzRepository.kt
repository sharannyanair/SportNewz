package com.app.sportzdomain.repository

import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import kotlinx.coroutines.flow.Flow

interface SportzRepository {
    /**
     * Method to fetch the sportz from Repository
     * @return Flow of ApiResponse with sportz data list
     */
    fun fetchSportzData(): Flow<ApiResponse<ResponseEntity>>
}