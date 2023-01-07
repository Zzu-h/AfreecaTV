package com.zzu.afreecatv.domain.usecase.broad.impl

import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.usecase.broad.GetBroadListByCategoryNoUseCase
import javax.inject.Inject


class GetBroadListByCategoryNoUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetBroadListByCategoryNoUseCase {

    override suspend operator fun invoke(categoryNo: String, pageNo: Int): Result<List<Broad>> =
        runCatching { broadRepository.getBroadListByCategoryNo(categoryNo, pageNo) }
}