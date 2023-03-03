package com.example.recipeapp.api

import com.example.recipeapp.model.RecipeResponse
import com.example.recipeapp.util.Constants.END_POINT
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(END_POINT)
    fun getRecipe() : Response<RecipeResponse>
}