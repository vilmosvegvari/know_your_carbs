package hu.bme.aut.knowyourcarbs.network.api

import retrofit2.http.*
import retrofit2.Response

import hu.bme.aut.jokes.data.network.model.RecipeDTO
import hu.bme.aut.jokes.data.network.model.RecipeResponseDTO

interface NutritionDetailsApi {
    /**
     * Get nutrition info
     * 
     * Responses:
     *  - 200: Recipe object containing number of servings (yield), total calories for the recipe (calories), nutrient content by nutrient type (totalNutrients, totalDaily), diet and health classification (dietLabels, healthLabels)
     *  - 404: The specified URL was not found or couldn’t be retrieved
     *  - 422: Couldn’t parse the recipe or extract the nutritional info
     *  - 555: Recipe with insufficient quality to process correctly
     * 
     * @param appId Application Id that you request from the service. Your 3scale application ID. 
     * @param appKey Application Key that you request from the service. Your 3scale application key. 
     * @param body  
     * @param force Forces the re-evaluation of the recipe. The value, if any, is ignored. (optional)
    * @return [RecipeResponseDTO]
     */
    @POST("nutrition-details")
    suspend fun handleNutritionInfoPost(@Query("app_id") appId: kotlin.String, @Query("app_key") appKey: kotlin.String, @Body body: RecipeDTO, @Query("force") force: kotlin.String? = null): Response<RecipeResponseDTO>

}
