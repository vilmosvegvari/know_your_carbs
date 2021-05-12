package hu.bme.aut.knowyourcarbs.ui.recipes

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.network.model.RecipeDTO
import hu.bme.aut.knowyourcarbs.ui.details.DetailFragment
import hu.bme.aut.knowyourcarbs.ui.edit.EditFragment
import hu.bme.aut.knowyourcarbs.ui.favourites.FavouritesFragment
import hu.bme.aut.knowyourcarbs.util.FragmentClickInterface
import kotlinx.android.synthetic.main.fragment_recipes.*
import kotlinx.android.synthetic.main.fragment_recipes.fab
import kotlinx.android.synthetic.main.fragment_recipes.progressBar
import kotlinx.android.synthetic.main.fragment_recipes.recyclerLayout
import kotlinx.android.synthetic.main.fragment_recipes.recyclerView


class RecipesFragment : Fragment(), FragmentClickInterface {
    companion object {
        fun newInstance() = RecipesFragment()
    }

    private lateinit var adapter: RecipeAdapter

    private lateinit var viewModel: RecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity()).get(RecipesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadRecipes()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = RecipeAdapter(this)
        recyclerView.adapter = adapter
        recyclerLayout.isGone = true

        fab.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("details")
                replace(R.id.contentFrame, EditFragment.newInstance(null))
            }
        }

        viewModel.recipes.observe(viewLifecycleOwner, { recipes ->
            adapter.submitList(recipes)
            progressBar.isGone = true
            recyclerLayout.isGone = false
        })

        changeToFavBtn.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("recipes")
                replace(R.id.contentFrame, FavouritesFragment.newInstance())
            }
        }

    }

    override fun clickOnRowItem(item: Recipe, position: Int) {
        parentFragmentManager.commit {
            addToBackStack("recipes")
            replace(R.id.contentFrame, DetailFragment.newInstance(item))
        }
    }
}