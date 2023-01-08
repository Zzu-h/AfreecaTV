package com.zzu.afreecatv.domain.usecase.broad

import androidx.paging.PagingData
import com.zzu.afreecatv.domain.model.Broad
import kotlinx.coroutines.flow.Flow

interface GetBroadListByCategoryNoUseCase {

    suspend operator fun invoke(categoryNo: String, size: Int = 1): Flow<PagingData<Broad>>
}