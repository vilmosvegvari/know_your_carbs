package hu.bme.aut.knowyourcarbs.mock.data

import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeDAO

class MockRecipeDAO : RecipeDAO {
    override fun getAll(): List<Recipe> {
        TODO("Not yet implemented")
    }

    override fun loadAllByIds(recipeIds: IntArray): List<Recipe> {
        TODO("Not yet implemented")
    }

    override fun findByTitle(title: String): Recipe {
        TODO("Not yet implemented")
    }

    override fun insertAll(vararg recipes: Recipe) {
        TODO("Not yet implemented")
    }

    override fun delete(recipe: Recipe) {
        TODO("Not yet implemented")
    }
}