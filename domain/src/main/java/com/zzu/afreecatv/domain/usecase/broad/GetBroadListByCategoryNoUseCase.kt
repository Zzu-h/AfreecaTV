package com.zzu.afreecatv.domain.usecase.broad

import com.zzu.afreecatv.domain.model.Broad

interface GetBroadListByCategoryNoUseCase {

    suspend operator fun invoke(categoryNo: String, pageNo: Int = 1): Result<List<Broad>>
}