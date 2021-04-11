package hu.bme.aut.knowyourcarbs.recipes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.details.DetailFragment
import hu.bme.aut.knowyourcarbs.favourites.FavouritesFragment
import kotlinx.android.synthetic.main.fragment_recipes.*

class RecipesFragment : Fragment() {
    companion object {
        fun newInstance() = RecipesFragment()
    }

    private lateinit var viewModel: RecipesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener{
            parentFragmentManager.commit {
                addToBackStack("recipes")
                replace(R.id.contentFrame,DetailFragment.newInstance())
            }
        }

        favSwitchButton.setOnClickListener{
            parentFragmentManager.commit {
                addToBackStack("recipes")
                replace(R.id.contentFrame,FavouritesFragment.newInstance())
            }
        }

        detailSwitchButton.setOnClickListener{
            parentFragmentManager.commit {
                addToBackStack("recipes")
                replace(R.id.contentFrame,DetailFragment.newInstance())
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecipesViewModel::class.java)
        // TODO: Use the ViewModel
    }
}