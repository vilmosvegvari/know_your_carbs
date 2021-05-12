package hu.bme.aut.knowyourcarbs.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    val uid: Int?,
    val title: String,
    val ingr: List<String>,
    val favourite: Boolean? = null,
    val url: String? = null,
    val summary: String? = null,
    val yield: String? = null,
    val ttime: String? = null,
    val img: String? = null,
    val prep: String? = null,
    val cuisine: String? = null,
    val mealtype: String? = null,
    val dishtype: String? = null,
    var kcal: Int? = null
)

object RecipeComparator: DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) =
        oldItem.uid == newItem.uid

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem == newItem

}