package hu.bme.aut.knowyourcarbs.mock.data

import dagger.Module
import dagger.Provides
import hu.bme.aut.knowyourcarbs.data.RecipeDAO
import javax.inject.Singleton

@Module
class MockDbModule {

    @Provides
    @Singleton
    fun provideRecipeDAO(): RecipeDAO = MockRecipeDAO()
}