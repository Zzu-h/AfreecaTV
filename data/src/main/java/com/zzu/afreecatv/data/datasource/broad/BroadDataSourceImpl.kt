package com.zzu.afreecatv.data.datasource.broad

import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.data.dto.BroadListDto
import com.zzu.afreecatv.data.service.BroadService
import javax.inject.Inject

class BroadDataSourceImpl @Inject constructor(
    private val broadService: BroadService
) : BroadDataSource {

    override suspend fun getAllBroadList(pageNo: Int): BroadListDto =
        broadService.getAllBroadList(pageNo)

    override suspend fun getBroadListByCategoryNo(categoryNo: String, pageNo: Int): List<BroadDto> =
        broadService.getBroadListByCategoryNo(categoryNo, pageNo).broad

    override suspend fun getBroadCategoryList(): List<BroadCategoryDto> =
        broadService.getBroadCategoryList().broadCategory
}