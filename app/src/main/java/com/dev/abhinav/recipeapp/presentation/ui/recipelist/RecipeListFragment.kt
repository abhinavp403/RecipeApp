package com.dev.abhinav.recipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.dev.abhinav.recipeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment: Fragment() {

    val viewModel: RecipeListViewModel by viewModels()

    override fun <I : Any?, O : Any?> prepareCall(contract: ActivityResultContract<I, O>, callback: ActivityResultCallback<O>): ActivityResultLauncher<I> {
        TODO("Not yet implemented")
    }

    override fun <I : Any?, O : Any?> prepareCall(contract: ActivityResultContract<I, O>, registry: ActivityResultRegistry, callback: ActivityResultCallback<O>): ActivityResultLauncher<I> {
        TODO("Not yet implemented")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                for(recipe in recipes){
                    Log.d("TAG", "RECIPE: ${recipe.title}")
                }

                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "RecipeList",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(21)
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = {
                            findNavController().navigate(R.id.viewRecipe)
                        }
                    ) {
                        Text(text = "To Recipe Fragment")
                    }
                }
            }
        }
    }
}