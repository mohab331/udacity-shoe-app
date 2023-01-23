package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeFragment : Fragment() {
    private lateinit var _binding: FragmentShoeBinding
    private  val shoeViewModel: ShoeViewModel by activityViewModels()


    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentShoeBinding.inflate(inflater , container , false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addShoeButton = binding.addShoe
        val nameEditText = binding.shoeName
        val companyEditText = binding.shoeCompany
        val sizeEditText = binding.shoeSize
        val descriptionEditText = binding.shoeDescription

        addShoeButton.setOnClickListener {
          val isShoeAddedSuccessfully:Boolean =  shoeViewModel.addShoe(shoe = Shoe(name = nameEditText.text.toString() , company = companyEditText.text.toString() , size = sizeEditText.text.toString() , description = descriptionEditText.text.toString()))
            if(isShoeAddedSuccessfully){
                findNavController().navigate(R.id.action_shoeFragment_to_shoeListFragment3)
            }

        }
    }
}