package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character_detail

import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI

sealed interface CharacterDetailState {
    object Loading : CharacterDetailState
    data class Success(val data: CharacterUI.ResultUI) : CharacterDetailState
    data class Error(val message: String?) : CharacterDetailState
}
