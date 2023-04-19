package com.example.mvvm_clean_architecture_paging3_hilt.domain.model

data class CharacterUI(
    val results: List<ResultUI>
) {
    data class ResultUI(
        val id: Int,
        val name: String,
        val image: String
    )
}
