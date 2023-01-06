package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadListDto

interface BroadDataSource {

    suspend fun getAllBroadList(): BroadListDto
}