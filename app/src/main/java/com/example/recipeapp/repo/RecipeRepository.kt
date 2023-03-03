package com.example.recipeapp.repo

import com.example.recipeapp.api.ApiService
import javax.inject.Inject

class RecipeRepository @Inject constructor(
    private val apiService:ApiService
){
    suspend fun getRecipe() = apiService.getRecipe()
}