package com.example.mvvm_clean_architecture_paging3_hilt.presentation.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_clean_architecture_paging3_hilt.common.loadImage
import com.example.mvvm_clean_architecture_paging3_hilt.databinding.ListItemBinding
import com.example.mvvm_clean_architecture_paging3_hilt.domain.model.CharacterUI

class CharacterAdapter: PagingDataAdapter<CharacterUI.ResultUI, CharacterAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object: DiffUtil.ItemCallback<CharacterUI.ResultUI>(){

            override fun areItemsTheSame(oldItem: CharacterUI.ResultUI, newItem: CharacterUI.ResultUI): Boolean {
                return oldItem.id ==newItem.id
            }
            override fun areContentsTheSame(oldItem: CharacterUI.ResultUI, newItem: CharacterUI.ResultUI): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvDescription.text = getItem(position)?.name
            imageView.loadImage(getItem(position)?.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
}
