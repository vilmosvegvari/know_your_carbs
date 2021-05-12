package hu.bme.aut.knowyourcarbs.mock.data

import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeDAO

class MockRecipeDAO : RecipeDAO {
    companion object {
        private val recipes = mutableListOf<Recipe>()
    }

    override fun getAll(): List<Recipe> {
        return recipes
    }

    override fun loadAllByIds(recipeIds: IntArray): List<Recipe> {
        val list = mutableListOf<Recipe>()
        recipeIds.forEach {
            val recipeOpt = recipes.find { recipe -> recipe.uid == it  }
            if (recipeOpt != null) {
                list.add(recipeOpt)
            }
        }
        return list
    }

    override fun findByTitle(title: String): Recipe {
        return recipes.findLast { recipe -> recipe.title.contains(title)  }!!
    }

    override fun update(recipe: Recipe) {
        val index = recipes.indexOf(recipe)
        recipes.set(index, recipe)
    }

    override fun insertAll(vararg recipesIncoming: Recipe) {
        recipesIncoming.forEach {
            recipes.add(it)
        }
    }

    override fun delete(recipe: Recipe) {
        recipes.remove(recipe)
    }

    fun deleteAll(){
        recipes.clear()
    }
}