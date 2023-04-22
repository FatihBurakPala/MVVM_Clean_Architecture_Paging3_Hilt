package com.example.mvvm_clean_architecture_paging3_hilt.domain.source

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result

interface RemoteDataSource {

    fun getCharacter(): Flow<PagingData<Result>>

    suspend fun getCharacterById(characterId: Int): Result
}
