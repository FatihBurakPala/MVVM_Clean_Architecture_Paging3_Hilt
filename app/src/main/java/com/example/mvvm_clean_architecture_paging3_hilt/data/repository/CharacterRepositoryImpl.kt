package com.example.mvvm_clean_architecture_paging3_hilt.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.example.mvvm_clean_architecture_paging3_hilt.data.mapper.toResultUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.repository.CharacterRepository
import com.example.mvvm_clean_architecture_paging3_hilt.domain.source.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterRepositoryImpl(private val remoteDataSource: RemoteDataSource) : CharacterRepository {

    override fun getCharacter(): Flow<PagingData<CharacterUI.ResultUI>> {
        return remoteDataSource.getCharacter().map { responseData ->
            responseData.map { it.toResultUI() }
        }
    }

    override suspend fun getCharacterById(characterId: Int): CharacterUI.ResultUI {
        return remoteDataSource.getCharacterById(characterId).toResultUI()
    }
}
