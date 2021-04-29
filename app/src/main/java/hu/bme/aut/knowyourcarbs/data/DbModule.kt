package hu.bme.aut.knowyourcarbs.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import hu.bme.aut.knowyourcarbs.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
abstract class DbModule {
    companion object {
        private const val DB_NAME = "carbs.db"

        @Provides
        @Singleton
        fun provideRecipeDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @Singleton
        fun provideRecipeDAO(appDatabase: AppDatabase) = appDatabase.recipeDAO()
    }
}