package hu.bme.aut.knowyourcarbs.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface  RecipeDAO {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE uid IN (:recipeIds)")
    fun loadAllByIds(recipeIds: IntArray): List<Recipe>

    @Query("SELECT * FROM recipe WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): Recipe

    @Insert
    fun insertAll(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}