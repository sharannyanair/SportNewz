package com.app.sportzdomain.usecase

import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.ResponseEntity
import com.app.sportzdomain.repository.SportzRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class SportzUseCaseImpl @Inject constructor(private val sportzRepository: SportzRepository) :
    SportzUseCase {
    override suspend fun execute(): Flow<ApiResponse<ResponseEntity>> {
        return sportzRepository.fetchSportzData()
    }

}