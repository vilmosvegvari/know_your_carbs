package hu.bme.aut.knowyourcarbs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation(){
        val recipeButton = findViewById<Button>(R.id.recipesButton)
        val favButton = findViewById<Button>(R.id.favouritesButton)
        val aboutButton = findViewById<Button>(R.id.aboutButton)

        recipeButton.setOnClickListener{
            val intent = Intent(this, RecipesActivity::class.java)
            startActivity(intent)
        }
    }
}