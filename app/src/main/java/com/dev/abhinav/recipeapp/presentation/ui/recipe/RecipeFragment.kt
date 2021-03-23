package com.dev.abhinav.recipeapp.presentation.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dev.abhinav.recipeapp.presentation.BaseApplication
import com.dev.abhinav.recipeapp.presentation.components.LoadingRecipeShimmer
import com.dev.abhinav.recipeapp.presentation.components.RecipeView
import com.dev.abhinav.recipeapp.presentation.components.util.SnackbarController
import com.dev.abhinav.recipeapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RecipeFragment: Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val snackbarController = SnackbarController(lifecycleScope)

    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("recipeId")?.let { recipeId ->
            viewModel.onTriggerEvent(RecipeEvent.GetRecipeEvent(recipeId))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply{
            setContent {
                val loading = viewModel.loading.value
                val recipe = viewModel.recipe.value
                val scaffoldState = rememberScaffoldState()

                AppTheme(
                    darkTheme = application.isDark.value,
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState
                ) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            if (loading && recipe == null) {
                                LoadingRecipeShimmer(imageHeight = 260.dp)
                            } else {
                                recipe?.let {
                                    if(it.id == 1) {
                                        snackbarController.showSnackbar(
                                            scaffoldState = scaffoldState,
                                            message = "Recipe Error",
                                            actionLabel = "OK"
                                        )
                                    } else {
                                        RecipeView(recipe = it)
                                    }
                                }
                            }
                        }
                    }
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = recipe?.let { recipe ->
                            "Selected recipeId: ${recipe.id}" }?: "LOADING...",
                        style = TextStyle(
                            fontSize = TextUnit.Sp(21)
                        )
                    )
                }
            }
        }
    }
}