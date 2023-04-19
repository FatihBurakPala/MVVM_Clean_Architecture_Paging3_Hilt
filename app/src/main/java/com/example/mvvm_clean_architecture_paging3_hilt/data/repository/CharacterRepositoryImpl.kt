package com.example.mvvm_clean_architecture_paging3_hilt.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.mvvm_clean_architecture_paging3_hilt.data.mapper.toResultUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.repository.CharacterRepository
import com.example.mvvm_clean_architecture_paging3_hilt.domain.source.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl(private val dataSource: DataSource) : CharacterRepository {

    override suspend fun getCharacter(): Flow<PagingData<CharacterUI.ResultUI>> {

        return dataSource.getCharacter().map { responseData ->
            responseData.map { it.toResultUI() }
        }
    }

//    override suspend fun getCharacter(page: Int): Flow<PagingData<CharacterUI.ResultUI>> = flow {
//
//        emit(Resource.Loading)
//
//        try {
//            emit(Resource.Success(remoteDataSource.getCharacter(page).toCharacterUI()))
//        } catch (t: Throwable) {
//            emit(Resource.Error(t))
//        }
//    }
}
