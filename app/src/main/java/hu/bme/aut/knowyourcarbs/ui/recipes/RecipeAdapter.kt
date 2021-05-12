package hu.bme.aut.knowyourcarbs.ui.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.data.RecipeComparator
import hu.bme.aut.knowyourcarbs.util.FragmentClickInterface

class RecipeAdapter(private val fragment: FragmentClickInterface) :
    ListAdapter<Recipe, RecipeAdapter.ViewHolder>(RecipeComparator) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val item = view
        val titleView: TextView = view.findViewById(R.id.item_title)
        val kcalView: TextView = view.findViewById(R.id.item_kcal)
        val ingrnumberView : TextView = view.findViewById(R.id.ingredientNumber)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recipe_row_item, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)

        viewHolder.item.setOnClickListener{
            fragment.clickOnRowItem(getItem(position),position);
        }

        with(viewHolder) {
            titleView.text = item.title
            kcalView.text = item.kcal.toString()
            ingrnumberView.text = item.ingr.size.toString()
        }
    }
}


