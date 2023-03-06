package com.example.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.recipeapp.databinding.RecipeRowBinding
import com.example.recipeapp.model.Result
import com.example.recipeapp.view.HomeFragmentDirections

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: RecipeRowBinding) : ViewHolder(binding.root)

    private val diffCallback = object: DiffUtil.ItemCallback<com.example.recipeapp.model.Result>(){
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.title==newItem.title
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem==newItem
        }

    }
    private val differ = AsyncListDiffer(this,diffCallback)
    var recipe:List<com.example.recipeapp.model.Result>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(RecipeRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return recipe.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipe[position]
        holder.binding.apply {
            tvTitleRecipe.text = currentRecipe.title
            imageView.load(currentRecipe.thumbnail){
                crossfade(true)
                crossfade(1000)
            }
        }
        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToDetailFragment(currentRecipe)
            it.findNavController().navigate(direction)
        }
    }
}