package com.zzu.afreecatv.domain.repository.broad

import androidx.paging.PagingData
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface BroadRepository {

    suspend fun getAllBroadList(pageNo: Int): List<Broad>
    suspend fun getBroadListByCategoryNo(categoryNo: String, size: Int): Flow<PagingData<Broad>>
    suspend fun getBroadCategoryList(): List<Category>
}