package hu.bme.aut.knowyourcarbs.data

import androidx.room.*

@Dao
interface  RecipeDAO {
    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM recipe WHERE uid IN (:recipeIds)")
    fun loadAllByIds(recipeIds: IntArray): List<Recipe>

    @Query("SELECT * FROM recipe WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): Recipe

    @Update
    fun update(recipe:Recipe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recipes: Recipe)

    @Delete
    fun delete(recipe: Recipe)
}