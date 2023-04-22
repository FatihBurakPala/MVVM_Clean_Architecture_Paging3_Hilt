package com.example.mvvm_clean_architecture_paging3_hilt.data.source

import retrofit2.http.GET
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Character
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    suspend fun getCharacter(
        @Query("page") page: Int
    ) : Character

    @GET("character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int
    ): Result
}
