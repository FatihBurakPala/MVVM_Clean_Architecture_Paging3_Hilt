package com.example.mvvm_clean_architecture_paging3_hilt.domain.repository

import androidx.paging.PagingData
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharacter(): Flow<PagingData<CharacterUI.ResultUI>>
}
