/**
* Edemam Nutrition Analysis - KnowYourCarbs
* Made for app KnowYourCarbs for an API Description.
*
* The version of the OpenAPI document: 1.0
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package hu.bme.aut.jokes.data.network.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 * @param title common name of the recipe
 * @param ingr ingredients (array of strings)
 * @param url url of the recipe’s location
 * @param summary a short description of the recipe
 * @param yield number of servings
 * @param ttime total time for preparation
 * @param img image link (absolute)
 * @param prep preparation instructions (free text)
 * @param cuisine type of cuisine
 * @param mealtype type of meal
 * @param dishtype type of dish
 */
@JsonClass(generateAdapter = true)
data class RecipeDTO (
    /* common name of the recipe */
    @Json(name = "title")
    val title: kotlin.String,
    /* ingredients (array of strings) */
    @Json(name = "ingr")
    val ingr: kotlin.collections.List<kotlin.String>,
    /* url of the recipe’s location */
    @Json(name = "url")
    val url: kotlin.String? = null,
    /* a short description of the recipe */
    @Json(name = "summary")
    val summary: kotlin.String? = null,
    /* number of servings */
    @Json(name = "yield")
    val yield: kotlin.String? = null,
    /* total time for preparation */
    @Json(name = "ttime")
    val ttime: kotlin.String? = null,
    /* image link (absolute) */
    @Json(name = "img")
    val img: kotlin.String? = null,
    /* preparation instructions (free text) */
    @Json(name = "prep")
    val prep: kotlin.String? = null,
    /* type of cuisine */
    @Json(name = "cuisine")
    val cuisine: kotlin.String? = null,
    /* type of meal */
    @Json(name = "mealtype")
    val mealtype: kotlin.String? = null,
    /* type of dish */
    @Json(name = "dishtype")
    val dishtype: kotlin.String? = null
)
