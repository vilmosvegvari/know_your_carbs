package hu.bme.aut.knowyourcarbs.util

import hu.bme.aut.knowyourcarbs.data.Recipe

interface FragmentClickInterface {
    fun clickOnRowItem(item: Recipe, position: Int);
}