package com.example.mvvm_clean_architecture_paging3_hilt.di

import com.example.mvvm_clean_architecture_paging3_hilt.data.repository.CharacterRepositoryImpl
import com.example.mvvm_clean_architecture_paging3_hilt.domain.repository.CharacterRepository
import com.example.mvvm_clean_architecture_paging3_hilt.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesCharacterRepository(
        remoteDataSource: RemoteDataSource
    ) : CharacterRepository = CharacterRepositoryImpl(remoteDataSource)
}
