package hu.bme.aut.knowyourcarbs

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import dagger.Provides
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesFragment
import hu.bme.aut.knowyourcarbs.ui.recipes.RecipesViewModel

@AndroidEntryPoint
class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            this.replace(R.id.contentFrame, RecipesFragment.newInstance());
        }
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_refresh, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.refresh_menu -> {
                recipeViewModel.loadRecipes()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }*/

}