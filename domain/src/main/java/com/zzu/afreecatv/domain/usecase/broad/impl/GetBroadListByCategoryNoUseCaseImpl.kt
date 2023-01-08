package com.zzu.afreecatv.domain.usecase.broad.impl

import androidx.paging.PagingData
import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.usecase.broad.GetBroadListByCategoryNoUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetBroadListByCategoryNoUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetBroadListByCategoryNoUseCase {

    override suspend operator fun invoke(categoryNo: String, size: Int): Flow<PagingData<Broad>> =
        broadRepository.getBroadListByCategoryNo(categoryNo, size)
}