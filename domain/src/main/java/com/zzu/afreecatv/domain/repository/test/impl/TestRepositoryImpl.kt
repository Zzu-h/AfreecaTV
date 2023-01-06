package com.zzu.afreecatv.domain.repository.test.impl

import com.zzu.afreecatv.data.datasource.broad.BroadDataSource
import com.zzu.afreecatv.domain.repository.test.TestRepository
import javax.inject.Inject

class TestRepositoryImpl @Inject constructor(
    private val broadDataSource: BroadDataSource
) : TestRepository {
}