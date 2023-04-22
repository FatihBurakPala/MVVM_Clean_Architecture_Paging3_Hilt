package com.example.mvvm_clean_architecture_paging3_hilt.di

import com.example.mvvm_clean_architecture_paging3_hilt.data.source.ApiService
import com.example.mvvm_clean_architecture_paging3_hilt.data.source.RemoteDataSourceImpl
import com.example.mvvm_clean_architecture_paging3_hilt.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideDataSource(
        apiService: ApiService
    ) : RemoteDataSource = RemoteDataSourceImpl(apiService)
}
