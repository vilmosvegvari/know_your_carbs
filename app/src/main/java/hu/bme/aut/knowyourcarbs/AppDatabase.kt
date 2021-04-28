package hu.bme.aut.knowyourcarbs

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeDAO
import hu.bme.aut.knowyourcarbs.util.Converters

@Database(entities = [Recipe::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDAO
}