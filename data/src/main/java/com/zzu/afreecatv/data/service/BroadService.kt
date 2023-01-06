package com.zzu.afreecatv.data.service

import com.zzu.afreecatv.data.dto.BroadListDto
import retrofit2.http.GET

interface BroadService {

    @GET("/broad/list")
    suspend fun getAllBroadList(): BroadListDto
}