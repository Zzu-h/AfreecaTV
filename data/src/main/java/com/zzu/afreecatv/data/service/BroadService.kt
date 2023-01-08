package com.zzu.afreecatv.data.service

import com.zzu.afreecatv.data.BuildConfig
import com.zzu.afreecatv.data.dto.BroadCategoryBodyDto
import com.zzu.afreecatv.data.dto.BroadListDto
import retrofit2.http.GET
import retrofit2.http.Query

interface BroadService {

    @GET("/broad/list")
    suspend fun getAllBroadList(
        @Query("page_no") pageNo: Int,
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID
    ): BroadListDto

    @GET("/broad/list")
    suspend fun getBroadListByCategoryNo(
        @Query("select_value") selectValue: String,
        @Query("page_no") pageNo: Int,
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID
    ): BroadListDto

    @GET("/broad/category/list")
    suspend fun getBroadCategoryList(
        @Query("client_id") clientId: String = BuildConfig.CLIENT_ID
    ): BroadCategoryBodyDto
}