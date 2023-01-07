package com.zzu.afreecatv.domain.repository.broad.impl

import com.zzu.afreecatv.data.datasource.broad.BroadDataSource
import com.zzu.afreecatv.domain.mapper.toModel
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import javax.inject.Inject

class BroadRepositoryImpl @Inject constructor(
    private val broadDataSource: BroadDataSource
) : BroadRepository {

    override suspend fun getAllBroadList(pageNo: Int): List<Broad> =
        broadDataSource.getAllBroadList(pageNo).broad.map { it.toModel() }

    override suspend fun getBroadListByCategoryNo(categoryNo: Int, pageNo: Int): List<Broad> =
        broadDataSource.getBroadListByCategoryNo(categoryNo, pageNo).map { it.toModel() }

    override suspend fun getBroadCategoryList(): List<Category> =
        broadDataSource.getBroadCategoryList().map { it.toModel() }
}