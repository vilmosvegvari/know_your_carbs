package hu.bme.aut.knowyourcarbs.ui.edit

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hu.bme.aut.knowyourcarbs.R
import hu.bme.aut.knowyourcarbs.data.Recipe
import hu.bme.aut.knowyourcarbs.ui.favourites.FavouritesViewModel
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment(private val recipe: Recipe?) : Fragment() {

    companion object {
        fun newInstance(recipe: Recipe?) = EditFragment(recipe)
    }

    private lateinit var viewModel: EditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(requireActivity()).get(EditViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edit_title.setText(recipe?.title)
        edit_type.setText(recipe?.dishtype)
        edit_ingr.setText(recipe?.ingr?.joinToString())
        edit_prep.setText(recipe?.prep)
        edit_fav.isChecked = recipe?.favourite == true

        if (recipe != null) edit_submitBtn.text = "Update"
        edit_submitBtn.setOnClickListener {
            if (recipe == null) {
                onSubmit()
            }
            else{
                onUpdate()
            }
        }
    }

    private fun onUpdate() {
        viewModel.onUpdate(
            Recipe(
                uid = recipe!!.uid,
                title = edit_title.text.toString(),
                dishtype = edit_type.text.toString(),
                prep = edit_prep.text.toString(),
                ingr = edit_ingr.text.toString().split(','),
                favourite = edit_fav.isChecked
            )
        )
    }

    private fun onSubmit() {
        viewModel.onSubmit(
            Recipe(
                uid = null,
                title = edit_title.text.toString(),
                dishtype = edit_type.text.toString(),
                prep = edit_prep.text.toString(),
                ingr = edit_ingr.text.toString().split(','),
                favourite = edit_fav.isChecked
            )
        )
    }

}