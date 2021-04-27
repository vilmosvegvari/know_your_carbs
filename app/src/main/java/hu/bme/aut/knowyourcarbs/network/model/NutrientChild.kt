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
 * @param label Display label
 * @param quantity Quantity of specified units
 * @param unit Units
 */
@JsonClass(generateAdapter = true)
data class NutrientChild (
    /* Display label */
    @Json(name = "label")
    val label: kotlin.String? = null,
    /* Quantity of specified units */
    @Json(name = "quantity")
    val quantity: java.math.BigDecimal? = null,
    /* Units */
    @Json(name = "unit")
    val unit: kotlin.String? = null
)

