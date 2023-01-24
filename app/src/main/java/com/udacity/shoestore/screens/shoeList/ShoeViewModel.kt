package com.udacity.shoestore.screens.shoeList

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

     var nameField  = ObservableField<String>()
     var companyField = ObservableField<String>()
     var sizeField = ObservableField<String>()
     var descriptionField = ObservableField<String>()


    // checking if attributes is not empty before adding it to the list
    public fun addShoe() : Boolean{
        if(validateShoeFields()) {
            shoes.value?.add(
                Shoe(
                    name = nameField.get().toString(),
                    company = companyField.get().toString(),
                    size = sizeField.get().toString(),
                    description = descriptionField.get().toString()
                )
            )
            clearData()
            return true
        }
        return  false
    }

    private fun validateShoeFields(): Boolean{
        if(nameField.get().isNullOrEmpty() || companyField.get().isNullOrEmpty()  ||sizeField.get().isNullOrEmpty()  || descriptionField.get().isNullOrEmpty() ){
            return false
        }
        return true
    }
    private fun clearData(){
        nameField.set("")
        companyField.set("")
        sizeField.set("")
        descriptionField.set("")
    }
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = mutableListOf()
    }

}
