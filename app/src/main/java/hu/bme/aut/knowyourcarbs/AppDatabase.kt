package hu.bme.aut.knowyourcarbs

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeDAO

@Database(entities = [Recipe::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO
}