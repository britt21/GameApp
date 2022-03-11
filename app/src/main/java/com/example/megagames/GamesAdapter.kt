package com.example.megagames

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.data.Games
import com.example.data.GamesItem
import com.example.megagames.databinding.ItemListBinding

class GamesAdapter : ListAdapter<GamesItem, GamesAdapter.GamesViewHolder>(DifferCallback) {

    companion object DifferCallback : DiffUtil.ItemCallback<GamesItem>(){
        override fun areItemsTheSame(oldItem: GamesItem, newItem: GamesItem): Boolean {
            return oldItem.id  == newItem.id

        }

        override fun areContentsTheSame(oldItem: GamesItem, newItem: GamesItem): Boolean {
           return oldItem.id === newItem.id
        }

    }
    class GamesViewHolder(private val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root){
         fun bind(gamesItem: GamesItem){
            binding.games = gamesItem
             binding.imgUrl.load(gamesItem.image)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        return GamesViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context)))

    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val curList = getItem(position)
        holder.bind(curList)

    }
}