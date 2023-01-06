package com.zzu.afreecatv.domain.di

import com.zzu.afreecatv.domain.usecase.test.TestUseCase
import com.zzu.afreecatv.domain.usecase.test.impl.TestUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Singleton
    @Binds
    abstract fun provideTestUseCase(
        testUseCase: TestUseCaseImpl
    ): TestUseCase
}