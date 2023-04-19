package com.example.mvvm_clean_architecture_paging3_hilt.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvm_clean_architecture_paging3_hilt.data.source.ApiService
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result

class CharacterPagingSource(private val apiService: ApiService): PagingSource<Int, Result>() {

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {


        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getCharacter(currentPage)
            val nextKey = if (currentPage < response.info.pages) {
                currentPage + 1
            } else {
                null
            }

            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage > 1) currentPage - 1 else null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

//        return try {
//            val currentPage = params.key ?: 1
//            val response = apiService.getCharacter(currentPage)
//            val data = response.results ?: emptyList()
//            val responseData = mutableListOf<Result>()
//            responseData.addAll(data)
//
//            LoadResult.Page(
//                data = responseData,
//                prevKey = if (currentPage == 1) null else -1,
//                nextKey = currentPage.plus(1)
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
    }
}
