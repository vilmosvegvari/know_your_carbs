package hu.bme.aut.knowyourcarbs.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(private val recipesInteractor: RecipesInteractor) : ViewModel() {

    fun onSubmit(recipe: Recipe){
        viewModelScope.launch {
            recipesInteractor.createRecipe(recipe)
        }
    }

    fun onUpdate(recipe: Recipe) {
        viewModelScope.launch {
            recipesInteractor.updateRecipe(recipe)
        }
    }
}