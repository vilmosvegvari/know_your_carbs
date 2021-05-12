package hu.bme.aut.knowyourcarbs.ui.details

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.view.isGone
import androidx.fragment.app.commit
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.edit.EditFragment
import hu.bme.aut.knowyourcarbs.ui.edit.EditViewModel
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipeAdapter
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_recipes.*

class DetailFragment(private val recipe: Recipe) : Fragment() {

    companion object {
        fun newInstance(recipe: Recipe) = DetailFragment(recipe)
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity()).get(DetailViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detail_title.text = recipe.title
        detail_ingr.text = recipe.ingr.joinToString()
        detail_kcal.text = recipe.kcal.toString() + " kcal"
        detail_prep.text = recipe.prep
        detail_type.text = recipe.dishtype
        detail_fav.isChecked = recipe.favourite == true

        detail_editBtn.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("details")
                replace(R.id.contentFrame, EditFragment.newInstance(recipe))
            }
        }

        detail_deleteBtn.setOnClickListener {
            viewModel.deleteRecipe(recipe)
        }
    }

}