package com.zzu.afreecatv.domain.usecase.broad.impl

import com.zzu.afreecatv.domain.model.Broad
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.usecase.broad.GetAllBroadListUseCase
import javax.inject.Inject

class GetAllBroadLisUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetAllBroadListUseCase {

    override suspend operator fun invoke(pageNo: Int): Result<List<Broad>> =
        runCatching { broadRepository.getAllBroadList(pageNo) }
}