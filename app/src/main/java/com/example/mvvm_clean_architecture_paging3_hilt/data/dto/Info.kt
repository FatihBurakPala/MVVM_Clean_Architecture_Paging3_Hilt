package com.example.mvvm_clean_architecture_paging3_hilt.data.dto

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any?
)
