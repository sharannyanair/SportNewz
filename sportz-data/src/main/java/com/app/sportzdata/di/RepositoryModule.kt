package com.app.sportzdata.di

import com.app.sportzdata.repository.SportzRepositoryImpl
import com.app.sportzdomain.repository.SportzRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    internal abstract fun bindSportzRepository(repository: SportzRepositoryImpl): SportzRepository
}