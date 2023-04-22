package com.example.mvvm_clean_architecture_paging3_hilt.data.mapper

import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Character
import com.example.mvvm_clean_architecture_paging3_hilt.data.dto.Result

fun Character.toCharacterUI() = CharacterUI(
    results = results.map { it.toResultUI() }
)
fun Result.toResultUI() = CharacterUI.ResultUI(
    id = id,
    name = name,
    image = image,
    gender = gender,
    species = species,
    status = status
)
