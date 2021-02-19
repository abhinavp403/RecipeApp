package com.dev.abhinav.recipeapp.network.responses

import com.dev.abhinav.recipeapp.network.model.RecipeDTO
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse (

    @SerializedName("count")
    var count: Int? = null,

    @SerializedName("results")
    var recipes: List<RecipeDTO>
)
