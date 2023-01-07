package com.zzu.afreecatv.domain.di

import com.zzu.afreecatv.domain.usecase.broad.GetAllBroadListUseCase
import com.zzu.afreecatv.domain.usecase.broad.GetBroadCategoryListUseCase
import com.zzu.afreecatv.domain.usecase.broad.GetBroadListByCategoryNoUseCase
import com.zzu.afreecatv.domain.usecase.broad.impl.GetAllBroadLisUseCaseImpl
import com.zzu.afreecatv.domain.usecase.broad.impl.GetBroadCategoryListUseCaseImpl
import com.zzu.afreecatv.domain.usecase.broad.impl.GetBroadListByCategoryNoUseCaseImpl
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
    abstract fun provideGetAllBroadListUseCase(
        getAllBroadListUseCase: GetAllBroadLisUseCaseImpl
    ): GetAllBroadListUseCase

    @Singleton
    @Binds
    abstract fun provideGetBroadListByCategoryNoUseCase(
        getBroadListByCategoryNoUseCase: GetBroadListByCategoryNoUseCaseImpl
    ): GetBroadListByCategoryNoUseCase

    @Singleton
    @Binds
    abstract fun provideGetBroadCategoryListUseCase(
        getBroadCategoryListUseCase: GetBroadCategoryListUseCaseImpl
    ): GetBroadCategoryListUseCase
}