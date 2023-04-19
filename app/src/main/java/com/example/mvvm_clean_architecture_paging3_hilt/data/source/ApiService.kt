package com.example.mvvm_clean_architecture_paging3_hilt.data.source

import com.example.mvvm_clean_architecture_paging3_hilt.common.Constants
import retrofit2.http.GET
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Character
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getCharacter(
        @Query("page") page: Int
    ) : Character
}
