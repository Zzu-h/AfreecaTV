package com.zzu.afreecatv.domain.repository.broad.impl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.zzu.afreecatv.data.datasource.broad.BroadDataSource
import com.zzu.afreecatv.domain.paging.BroadPagingSource
import com.zzu.afreecatv.domain.mapper.toModel
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BroadRepositoryImpl @Inject constructor(
    private val broadDataSource: BroadDataSource
) : BroadRepository {

    override suspend fun getAllBroadList(pageNo: Int): List<Broad> =
        broadDataSource.getAllBroadList(pageNo).broad.map { it.toModel() }

    override suspend fun getBroadListByCategoryNo(
        categoryNo: String,
        size: Int
    ): Flow<PagingData<Broad>> =
        Pager(
            config = PagingConfig(
                pageSize = size,
                initialLoadSize = size,
                enablePlaceholders = false
            ), pagingSourceFactory = { BroadPagingSource(broadDataSource, categoryNo) }
        ).flow.map { it.map { item -> item.toModel() } }

    override suspend fun getBroadCategoryList(): List<Category> =
        broadDataSource.getBroadCategoryList().map { it.toModel() }
}