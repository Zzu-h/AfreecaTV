package com.zzu.afreecatv.domain.repository.broad

import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.data.dto.BroadListDto

interface BroadRepository {

    suspend fun getAllBroadList(pageNo: Int): BroadListDto
    suspend fun getBroadListByCategoryNo(categoryNo: Int, pageNo: Int): List<BroadDto>
    suspend fun getBroadCategoryList(): List<BroadCategoryDto>
}