package com.app.sportzdata.service

import com.app.sportzdomain.data.model.ResponseEntity
import retrofit2.Response
import retrofit2.http.Headers
import retrofit2.http.POST

interface DataApiService {
    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("/results")
    suspend fun getResults(): Response<ResponseEntity>

}