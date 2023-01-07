package com.zzu.afreecatv.domain.usecase.broad.impl

import com.zzu.afreecatv.domain.model.Category
import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.usecase.broad.GetBroadCategoryListUseCase
import javax.inject.Inject

class GetBroadCategoryListUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : GetBroadCategoryListUseCase {

    override suspend operator fun invoke(): Result<List<Category>> =
        runCatching { broadRepository.getBroadCategoryList() }
}