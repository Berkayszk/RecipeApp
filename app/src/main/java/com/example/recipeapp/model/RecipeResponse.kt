package com.example.recipeapp.model

data class RecipeResponse(
    val href:String,
    val results:List<Result>,
    val title:String,
    val version: Double
)
