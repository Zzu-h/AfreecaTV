package com.zzu.afreecatv.data.service

import com.zzu.afreecatv.data.BuildConfig
import com.zzu.afreecatv.data.dto.BroadListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadService {

    @GET("/broad/list")
    suspend fun getAllBroadList(
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID
    ): BroadListDto
}