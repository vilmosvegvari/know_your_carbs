package hu.bme.aut.knowyourcarbs.ui.favourites

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.commit
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.details.DetailFragment
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipeAdapter
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesFragment
import hu.bme.aut.knowyourcarbs.util.FragmentClickInterface
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_favourites.progressBar
import kotlinx.android.synthetic.main.fragment_favourites.recyclerLayout
import kotlinx.android.synthetic.main.fragment_favourites.recyclerView

class FavouritesFragment : Fragment(), FragmentClickInterface {

    companion object {
        fun newInstance() = FavouritesFragment()
    }

    private lateinit var viewModel: FavouritesViewModel

    private lateinit var adapter: RecipeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity()).get(FavouritesViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFavourites()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeToAllBtn.setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack("recipes")
                replace(R.id.contentFrame, RecipesFragment.newInstance())
            }
        }

        adapter = RecipeAdapter(this)

        recyclerView.adapter = adapter
        recyclerLayout.isGone = true

        viewModel.favourites.observe(viewLifecycleOwner, { recipes ->
            adapter.submitList(recipes)
            progressBar.isGone = true
            recyclerLayout.isGone = false
        })
    }

    override fun clickOnRowItem(item: Recipe, position: Int) {
        parentFragmentManager.commit {
            addToBackStack("recipes")
            replace(R.id.contentFrame, DetailFragment.newInstance(item))
        }
    }

}