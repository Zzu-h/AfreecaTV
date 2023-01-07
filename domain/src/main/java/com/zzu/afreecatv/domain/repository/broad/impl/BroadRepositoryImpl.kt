package com.zzu.afreecatv.domain.repository.broad.impl

import com.zzu.afreecatv.data.datasource.broad.BroadDataSource
import com.zzu.afreecatv.data.dto.BroadCategoryDto
import com.zzu.afreecatv.data.dto.BroadDto
import com.zzu.afreecatv.data.dto.BroadListDto
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import javax.inject.Inject

class BroadRepositoryImpl @Inject constructor(
    private val broadDataSource: BroadDataSource
) : BroadRepository {

    override suspend fun getAllBroadList(pageNo: Int): BroadListDto =
        broadDataSource.getAllBroadList(pageNo)

    override suspend fun getBroadListByCategoryNo(categoryNo: Int, pageNo: Int): List<BroadDto> =
        broadDataSource.getBroadListByCategoryNo(categoryNo, pageNo)

    override suspend fun getBroadCategoryList(): List<BroadCategoryDto> =
        broadDataSource.getBroadCategoryList()
}