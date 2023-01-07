package com.zzu.afreecatv.domain.usecase.test.impl

import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.usecase.test.TestUseCase
import javax.inject.Inject

class TestUseCaseImpl @Inject constructor(
    private val broadRepository: BroadRepository
) : TestUseCase {

}