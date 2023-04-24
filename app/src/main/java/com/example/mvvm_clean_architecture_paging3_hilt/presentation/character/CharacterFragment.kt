package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvvm_clean_architecture_paging3_hilt.R
import com.example.mvvm_clean_architecture_paging3_hilt.common.viewBinding
import com.example.mvvm_clean_architecture_paging3_hilt.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {

    private val binding by viewBinding(FragmentCharacterBinding::bind)
    private val viewModel: CharacterViewModel by hiltNavGraphViewModels(R.id.main_nav)
    private val characterAdapter = CharacterAdapter(::itemSetClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        loadData()

        viewLifecycleOwner.lifecycleScope.launch {
            characterAdapter.loadStateFlow.collect {
                sourceRefresh(it)
                sourceAppend(it)
                sourcePrepend(it)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = characterAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
        }
    }

    private fun loadData() = viewLifecycleOwner.lifecycleScope.launch {
        viewModel.characters.collect {
            when (it) {
                is CharacterState.Loading -> {}
                is CharacterState.Error -> {}
                is CharacterState.Success -> {
                    characterAdapter.submitData(it.data)
                }
            }
        }
    }

    private fun itemSetClick(characterId: Int) {
        findNavController().navigate(
            CharacterFragmentDirections
                .actionCharacterFragmentToCharacterDetailFragment(characterId)
        )
    }

    private fun sourceRefresh(loadStates: CombinedLoadStates) {
        when (val refresh = loadStates.source.refresh) {
            is LoadState.Loading -> {}
            is LoadState.NotLoading -> {}
            is LoadState.Error -> {}
        }
    }

    private fun sourceAppend(loadStates: CombinedLoadStates) {
        when (val append = loadStates.source.append) {
            is LoadState.Loading -> {}
            is LoadState.NotLoading -> {}
            is LoadState.Error -> {}
        }
    }

    private fun sourcePrepend(loadStates: CombinedLoadStates) {
        when (val prepend = loadStates.source.prepend) {
            is LoadState.Loading -> {}
            is LoadState.NotLoading -> {}
            is LoadState.Error -> {}
        }
    }
}
