package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvm_clean_architecture_paging3_hilt.R
import com.example.mvvm_clean_architecture_paging3_hilt.common.viewBinding
import com.example.mvvm_clean_architecture_paging3_hilt.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private lateinit var characterAdapter: CharacterAdapter
    private val viewModel: CharacterViewModel by hiltNavGraphViewModels(R.id.main_nav)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        loadData()
    }

    private fun setupRecyclerView() {
        characterAdapter = CharacterAdapter()
        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
        }
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characters.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is CharacterState.Loading -> {}
                    is CharacterState.Error -> {}
                    is CharacterState.Success -> {
                        characterAdapter.submitData(it.data)
                    }
                }
            }
        }
    }
//    private fun loadData() {
//        lifecycleScope.launch {
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.characterList.collect {
//                    charactersAdapter.submitData(it)
//                }
//            }
//        }
//    }
}
