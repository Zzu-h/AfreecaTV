package com.zzu.afreecatv.domain.usecase.broad

import com.zzu.afreecatv.domain.model.Category

interface GetBroadCategoryListUseCase {

    suspend operator fun invoke(): Result<List<Category>>
}