package hu.bme.aut.knowyourcarbs

import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.mock.data.MockRecipeDAO
import hu.bme.aut.knowyourcarbs.mock.network.MockApi
import org.junit.*
import org.junit.Test

class Test {
    private lateinit var daoMock: MockRecipeDAO
    private lateinit var apiMock: MockApi


    @Before
    fun setup() {
        daoMock = MockRecipeDAO()
        apiMock = MockApi()
    }

    @After
    fun clearDatabase() {
        daoMock.deleteAll()
    }

    @Test
    fun TestRecipeAddMock() {
        val recipe = Recipe(3, "This is a title!", listOf("1 apple"))
        daoMock.insertAll(recipe)
        val list = daoMock.getAll()
        assert(list.size == 1)
        assert(list[0] == recipe)
    }

    @Test
    fun TestRecipeDeleteMock() {
        val recipe = Recipe(2, "This is a title!", listOf("1 apple"))
        daoMock.insertAll(recipe)
        var list = daoMock.getAll()
        assert(list.size == 1)
        assert(list[0] == recipe)
        daoMock.delete(recipe)
        list = daoMock.getAll()
        assert(list.size == 0)
    }

    @Test
    fun TestRecipeFindMock() {
        val recipe = Recipe(1, "This is a title!", listOf("1 apple"))
        val recipe2 = Recipe(
            2, "title",
            listOf("3 bananas")
        )
        daoMock.insertAll(recipe, recipe2)
        val list = daoMock.getAll()
        assert(list.size == 2)
        assert(list[0] == recipe)
        assert(list[1] == recipe2)
        val recipeFound = daoMock.findByTitle("This")
        assert(recipe == recipeFound)
        val recipeFound2 = daoMock.findByTitle("title");
        assert(recipe2 == recipeFound2)
    }


}