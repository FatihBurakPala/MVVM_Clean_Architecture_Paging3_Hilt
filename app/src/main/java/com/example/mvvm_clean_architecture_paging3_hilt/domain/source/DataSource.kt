package com.example.mvvm_clean_architecture_paging3_hilt.domain.source

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result

interface DataSource {
    suspend fun getCharacter(): Flow<PagingData<Result>>
}
