package com.zzu.afreecatv.domain.di

import com.zzu.afreecatv.domain.repository.test.TestRepository
import com.zzu.afreecatv.domain.repository.test.impl.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideTestRepository(
        testRepository: TestRepositoryImpl
    ): TestRepository
}