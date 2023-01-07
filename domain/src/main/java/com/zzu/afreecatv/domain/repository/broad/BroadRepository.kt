package com.zzu.afreecatv.domain.repository.broad

import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.model.Category

interface BroadRepository {

    suspend fun getAllBroadList(pageNo: Int): List<Broad>
    suspend fun getBroadListByCategoryNo(categoryNo: String, pageNo: Int): List<Broad>
    suspend fun getBroadCategoryList(): List<Category>
}