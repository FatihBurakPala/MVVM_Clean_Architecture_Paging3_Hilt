package com.example.mvvm_clean_architecture_paging3_hilt.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvm_clean_architecture_paging3_hilt.common.viewBinding
import com.example.mvvm_clean_architecture_paging3_hilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
