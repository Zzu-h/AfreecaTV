package com.zzu.afreecatv.domain.usecase.broad

import com.zzu.afreecatv.domain.model.Broad

interface GetAllBroadListUseCase {

    suspend operator fun invoke(pageNo: Int = 1): Result<List<Broad>>
}