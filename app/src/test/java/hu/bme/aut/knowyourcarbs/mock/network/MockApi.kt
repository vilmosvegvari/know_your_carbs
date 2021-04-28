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
        TODO("Not yet implemented")
    }
}