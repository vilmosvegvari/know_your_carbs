package hu.bme.aut.knowyourcarbs.mock.network

import hu.bme.aut.knowyourcarbs.network.api.NutritionDetailsApi
import hu.bme.aut.knowyourcarbs.network.model.RecipeDTO
import hu.bme.aut.knowyourcarbs.network.model.RecipeResponseDTO
import retrofit2.Response


class MockApi : NutritionDetailsApi {

    override suspend fun handleNutritionInfoPost(
        appId: String,
        appKey: String,
        body: RecipeDTO,
        force: kotlin.String?
    ): Response<RecipeResponseDTO> {
        return Response.success(RecipeResponseDTO(
            uri = "http://www.edamam.com/ontologies/edamam.owl#recipe_94dbd867e9094d4f9c08bb7649f24828",
            yieldData = 2,
            calories = 246,
        ))

    }
}