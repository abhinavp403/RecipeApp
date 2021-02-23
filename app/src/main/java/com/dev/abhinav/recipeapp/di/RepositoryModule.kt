package com.dev.abhinav.recipeapp.di

import com.dev.abhinav.recipeapp.network.RecipeService
import com.dev.abhinav.recipeapp.network.model.RecipeDTOMapper
import com.dev.abhinav.recipeapp.repository.RecipeRepository
import com.dev.abhinav.recipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(recipeService: RecipeService, recipeMapper: RecipeDTOMapper): RecipeRepository {
        return RecipeRepositoryImpl(
                recipeService = recipeService,
                mapper = recipeMapper
        )
    }
}
