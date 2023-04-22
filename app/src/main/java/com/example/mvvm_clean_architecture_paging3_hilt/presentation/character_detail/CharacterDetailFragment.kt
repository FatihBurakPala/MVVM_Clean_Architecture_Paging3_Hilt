package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.mvvm_clean_architecture_paging3_hilt.R
import com.example.mvvm_clean_architecture_paging3_hilt.common.loadImage
import com.example.mvvm_clean_architecture_paging3_hilt.common.viewBinding
import com.example.mvvm_clean_architecture_paging3_hilt.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {

    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    private val viewModel: CharacterDetailViewModel by hiltNavGraphViewModels(R.id.main_nav)
    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacterById(args.characterId)
        loadData()
    }

    private fun loadData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characterDetail.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect { response ->
                when (response) {
                    is CharacterDetailState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                    is CharacterDetailState.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                    }
                    is CharacterDetailState.Success -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            imageCharacter.loadImage(response.data.image)
                            textName.text = response.data.name
                            textGender.text = response.data.gender
                            textSpecies.text = response.data.species
                            textStatus.text = response.data.status
                        }
                    }
                }
            }
        }
    }
}
