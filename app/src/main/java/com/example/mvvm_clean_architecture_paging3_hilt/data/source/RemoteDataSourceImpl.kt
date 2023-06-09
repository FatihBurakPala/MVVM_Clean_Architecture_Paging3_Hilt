package com.example.mvvm_clean_architecture_paging3_hilt.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mvvm_clean_architecture_paging3_hilt.common.Constants
import com.example.mvvm_clean_architecture_paging3_hilt.domain.source.RemoteDataSource
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result
import com.example.mvvm_clean_architecture_paging3_hilt.data.paging.CharacterPagingSource
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceImpl (private val apiService: ApiService): RemoteDataSource {

    override fun getCharacter(): Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.NETWORK_PAGE_SIZE),
            pagingSourceFactory = { CharacterPagingSource(apiService) }
        ).flow
    }

    override suspend fun getCharacterById(characterId: Int): Result {
        return apiService.getCharacterById(characterId)
    }
}
