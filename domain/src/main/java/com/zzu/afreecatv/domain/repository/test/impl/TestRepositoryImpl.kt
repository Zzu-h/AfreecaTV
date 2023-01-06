package com.zzu.afreecatv.domain.repository.test.impl

import com.zzu.afreecatv.data.datasource.test.TestDataSource
import com.zzu.afreecatv.domain.repository.test.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val testDataSource: TestDataSource
) : TestRepository {
}