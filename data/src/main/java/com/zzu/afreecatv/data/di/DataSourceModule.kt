package com.zzu.afreecatv.data.di

import com.zzu.afreecatv.data.datasource.test.TestDataSource
import com.zzu.afreecatv.data.datasource.test.TestDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideTestDataSource(
        testDataSource: TestDataSourceImpl
    ): TestDataSource
}