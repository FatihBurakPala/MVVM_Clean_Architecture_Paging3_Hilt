package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_clean_architecture_paging3_hilt.common.Resource
import com.example.mvvm_clean_architecture_paging3_hilt.domain.use_case.CharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val useCase: CharacterByIdUseCase) : ViewModel() {

    private val _characterDetail = MutableStateFlow<CharacterDetailState>(CharacterDetailState.Loading)
    val characterDetail = _characterDetail.asStateFlow()

    fun getCharacterById(characterId: Int) = viewModelScope.launch {

        when (val result = useCase(characterId)) {
            is Resource.Success -> {
                _characterDetail.value = CharacterDetailState.Success(result.data)
            }
            is Resource.Loading -> {
                _characterDetail.value = CharacterDetailState.Loading
            }
            is Resource.Error -> {
                _characterDetail.value = CharacterDetailState.Error(result.throwable.message)
            }
        }
    }
}
