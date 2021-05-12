package hu.bme.aut.knowyourcarbs.ui.favourites

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val recipesInteractor: RecipesInteractor) :
    ViewModel() {

    val favourites: MutableLiveData<List<Recipe>> by lazy {
        MutableLiveData<List<Recipe>>().also {
            loadFavourites()
        }
    }

    fun loadFavourites() {
        viewModelScope.launch {
            val recipes1 = recipesInteractor.getFavRecipes()
            favourites.postValue(recipes1)
        }
    }
}