package com.app.sportzdomain.di

import com.app.sportzdomain.usecase.SportzUseCase
import com.app.sportzdomain.usecase.SportzUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SportzUseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindSportzUseCase(useCaseImpl: SportzUseCaseImpl): SportzUseCase
}