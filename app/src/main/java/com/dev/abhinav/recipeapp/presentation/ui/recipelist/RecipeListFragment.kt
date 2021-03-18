package com.dev.abhinav.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dev.abhinav.recipeapp.presentation.BaseApplication
import com.dev.abhinav.recipeapp.presentation.components.CircularIndeterminateProgressBar
import com.dev.abhinav.recipeapp.presentation.components.LoadingRecipeListShimmer
import com.dev.abhinav.recipeapp.presentation.components.RecipeCard
import com.dev.abhinav.recipeapp.presentation.theme.AppTheme
//import com.dev.abhinav.recipeapp.presentation.components.SearchAppBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(darkTheme = application.isDark.value) {
                    val recipes = viewModel.recipes.value
                    val query = viewModel.query.value
                    val selectedCategory = viewModel.selectedCategory.value
                    val categoryScrollPosition = viewModel.categoryScrollPosition
                    val loading = viewModel.loading.value

                    Column(modifier = Modifier.background(color = MaterialTheme.colors.primary)) {
//                      SearchAppBar(
//                            query = query,
//                            onQueryChanged = viewModel::onQueryChanged,
//                            onExecuteSearch = viewModel::newSearch,
//                            categories = getAllFoodCategories(),
//                            selectedCategory = selectedCategory,
//                            onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
//                            scrollPosition = categoryScrollPosition,
//                            onChangeScrollPosition = viewModel::onChangeCategoryScrollPosition,
//                            onToggleTheme = {
//                                application.toggleLightTheme()
//                            }
//                    )

                        Box(modifier = Modifier.fillMaxSize()) {
                            if (loading) {
                                LoadingRecipeListShimmer(imageHeight = 250.dp)
                            } else {
                                LazyColumn {
                                    itemsIndexed(
                                        items = recipes
                                    ) { index, recipe ->
                                        RecipeCard(recipe = recipe, onClick = {})
                                    }
                                }
                            }
                            CircularIndeterminateProgressBar(
                                isDisplayed = loading,
                                verticalBias = 0.3f
                            )
                        }
                    }
                }
            }
        }
    }
}