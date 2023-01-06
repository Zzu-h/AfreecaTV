package com.zzu.afreecatv.domain.usecase.test.impl

import com.zzu.afreecatv.domain.repository.test.TestRepository
import com.zzu.afreecatv.domain.usecase.test.TestUseCase
import javax.inject.Inject

class TestUseCaseImpl @Inject constructor(
    private val testRepository: TestRepository
) : TestUseCase {

}