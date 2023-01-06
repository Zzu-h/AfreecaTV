package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.data.dto.BroadListDto

interface BroadDataSource {

    suspend fun getAllBroadList(pageNo: Int = 1): BroadListDto
    suspend fun getBroadListByCategoryNo(categoryNo: Int, pageNo: Int = 1): List<BroadDto>
    suspend fun getBroadCategoryList(): List<BroadCategoryDto>
}