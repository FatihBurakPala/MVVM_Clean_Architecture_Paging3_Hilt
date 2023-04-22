package com.example.mvvm_clean_architecture_paging3_hilt.domain.use_case

import androidx.paging.PagingData
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import com.example.mvvm_clean_architecture_paging3_hilt.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<CharacterUI.ResultUI>> {
        return repository.getCharacter()
    }
}
