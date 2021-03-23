package com.dev.abhinav.recipeapp.presentation.ui.recipelist

sealed class RecipeListEvent {

    object NewSearchEvent : RecipeListEvent()

    object NextPageEvent : RecipeListEvent()

    object RestoreStateEvent : RecipeListEvent()
}