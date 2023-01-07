package com.zzu.afreecatv.domain.di

import com.zzu.afreecatv.domain.repository.broad.BroadRepository
import com.zzu.afreecatv.domain.repository.broad.impl.BroadRepositoryImpl
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
    abstract fun provideBroadRepository(
        broadRepository: BroadRepositoryImpl
    ): BroadRepository
}