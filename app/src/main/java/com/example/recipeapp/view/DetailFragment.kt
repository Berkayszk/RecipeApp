package com.example.recipeapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.recipeapp.R
import com.example.recipeapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private val args:DetailFragmentArgs by navArgs()
    private lateinit var recipe : com.example.recipeapp.model.Result

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipe = args.recipe

        populateUı()
    }

    private fun populateUı(){
        binding.apply {
            tvIngredientsDetails.text = recipe.ingredients
            tvTitleRecipeDetails.text = recipe.title
            ivDetails.load(recipe.thumbnail){
                crossfade(1000)
                crossfade(true)
            }
            btnOpenWebView.setOnClickListener {
                val direction = DetailFragmentDirections.actionDetailFragmentToWebViewFragment(recipe)
                it.findNavController().navigate(direction)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
