package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.data.dto.BroadListDto

interface BroadDataSource {

    suspend fun getAllBroadList(pageNo: Int): BroadListDto
    suspend fun getBroadListByCategoryNo(categoryNo: String, pageNo: Int): List<BroadDto>
    suspend fun getBroadCategoryList(): List<BroadCategoryDto>
}