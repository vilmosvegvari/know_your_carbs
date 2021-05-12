package hu.bme.aut.knowyourcarbs.ui.recipes

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import hu.bme.aut.knowyourcarbs.Hilt_MainActivity
import hu.bme.aut.knowyourcarbs.MainActivity
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeDAO
import hu.bme.aut.knowyourcarbs.network.api.NutritionDetailsApi
import hu.bme.aut.knowyourcarbs.network.model.RecipeDTO
import hu.bme.aut.knowyourcarbs.network.model.RecipeResponseDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val recipesInteractor: RecipesInteractor) :
    ViewModel() {

    val recipes: MutableLiveData<List<Recipe>> by lazy {
        MutableLiveData<List<Recipe>>().also {
            loadRecipes()
        }
    }

    fun loadRecipes() {
        viewModelScope.launch {
            val recipes1 = recipesInteractor.getRecipes()
            recipes.postValue(recipes1)
        }
    }

}

class RecipesInteractor @Inject constructor(
    private val recipeDAO: RecipeDAO,
    private val nutritionDetailsApi: NutritionDetailsApi) {

    suspend fun getRecipes(): List<Recipe> = withContext(Dispatchers.IO) {
        recipeDAO.getAll()
    }

    suspend fun getNutrition(recipe: RecipeDTO): RecipeResponseDTO = withContext(Dispatchers.IO) {
        val response = nutritionDetailsApi.handleNutritionInfoPost(
            appId = "80171bdc",
            appKey = "eeb554c01ce6012bd4a3a6c3739b9a81",
            body = recipe
        )

        response.body()!!
    }

    private fun createDTO(recipe: Recipe): RecipeDTO{
        return RecipeDTO(
            title = recipe.title,
            ingr = recipe.ingr,
            prep = recipe.prep,
            dishtype = recipe.dishtype,
        )
    }

    suspend fun createRecipe(recipe: Recipe) = withContext(Dispatchers.IO){
        val dto = createDTO(recipe)
        val kcal = getNutrition(recipe = dto).calories
        recipe.kcal = kcal
        recipeDAO.insertAll(recipe)
    }

    suspend fun updateRecipe(recipe: Recipe) = withContext(Dispatchers.IO){
        val kcal = getNutrition(recipe = createDTO(recipe)).calories
        recipe.kcal = kcal
        recipeDAO.update(recipe)
    }

    suspend fun getFavRecipes(): List<Recipe> = withContext(Dispatchers.IO){
        val recipes = recipeDAO.getAll()
        recipes.filter { recipe -> recipe.favourite == true }
    }

    suspend fun deleteRecipe(recipe: Recipe) = withContext(Dispatchers.IO){
        recipeDAO.delete(recipe)
    }
}