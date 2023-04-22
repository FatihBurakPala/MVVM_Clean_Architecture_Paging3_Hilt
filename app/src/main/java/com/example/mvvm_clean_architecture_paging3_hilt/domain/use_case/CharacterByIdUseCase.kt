package com.example.mvvm_clean_architecture_paging3_hilt.domain.use_case

import com.example.mvvm_clean_architecture_paging3_hilt.common.Resource
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(characterId: Int): Resource<CharacterUI.ResultUI> {
        return try {
            Resource.Loading
            Resource.Success(repository.getCharacterById(characterId))
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
