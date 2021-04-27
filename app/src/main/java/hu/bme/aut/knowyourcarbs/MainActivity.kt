package hu.bme.aut.knowyourcarbs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint
import hu.bme.aut.knowyourcarbs.recipes.RecipesFragment

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            this.replace(R.id.contentFrame,RecipesFragment.newInstance());
        }
    }

}