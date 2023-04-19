package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mvvm_clean_architecture_paging3_hilt.domain.use_case.CharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: CharacterUseCase) : ViewModel() {

    private val _characters = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val characters = _characters.asStateFlow()

    init {
        getCharacter()
    }

    private fun getCharacter() = viewModelScope.launch {
        useCase().cachedIn(viewModelScope).collect {
            _characters.value = CharacterState.Success(it)
        }
    }

//    private fun getAllCharacter() {
//        viewModelScope.launch {
//            getAllCharacterUseCase().cachedIn(viewModelScope).collect { pagingData ->
//                pagingData.map { it.toMap() }.also {
//                    _allCharacter.value = CharacterUiState.Success(it)
//                }
//            }
//        }
//    }

//    val characterList = Pager(PagingConfig(1)) {
//        CharacterPagingSource(repository)
//    }.flow.cachedIn(viewModelScope)
}
