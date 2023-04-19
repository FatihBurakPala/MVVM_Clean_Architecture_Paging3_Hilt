package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character

import androidx.paging.PagingData
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI

sealed interface CharacterState {
    object Loading : CharacterState
    data class Success(val data: PagingData<CharacterUI.ResultUI>) : CharacterState
    data class Error(val message: String?) : CharacterState
}
