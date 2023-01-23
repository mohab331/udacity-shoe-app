package com.udacity.shoestore.screens.shoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    // checking if attributes is not empty before adding it to the list
    public fun addShoe(shoe: Shoe) : Boolean{
        if(shoe.company.isNullOrEmpty() || shoe.name.isNullOrEmpty() || shoe.size.isNullOrEmpty() || shoe.description.isNullOrEmpty()){
            return false
        }
        shoes.value?.add(shoe)
        return true
    }

    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = mutableListOf()
    }

}
