package com.dev.abhinav.recipeapp.repository

import com.dev.abhinav.recipeapp.domain.model.Recipe
import com.dev.abhinav.recipeapp.network.RecipeService
import com.dev.abhinav.recipeapp.network.model.RecipeDTOMapper

class RecipeRepositoryImpl(private val recipeService: RecipeService, private val mapper: RecipeDTOMapper): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomainModel(recipeService.get(token = token, id))
    }
}