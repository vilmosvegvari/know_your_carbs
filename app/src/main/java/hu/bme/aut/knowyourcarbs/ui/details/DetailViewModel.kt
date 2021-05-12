package hu.bme.aut.knowyourcarbs.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val recipesInteractor: RecipesInteractor) : ViewModel() {

    fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch {
            recipesInteractor.deleteRecipe(recipe)
        }
    }
}