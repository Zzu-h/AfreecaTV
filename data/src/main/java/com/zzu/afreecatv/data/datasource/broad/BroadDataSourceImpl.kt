package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadListDto
import com.zzu.afreecatv.data.service.BroadService
import javax.inject.Inject

class BroadDataSourceImpl @Inject constructor(
    private val broadService: BroadService
) : BroadDataSource {

    override suspend fun getAllBroadList(): BroadListDto = broadService.getAllBroadList()
}