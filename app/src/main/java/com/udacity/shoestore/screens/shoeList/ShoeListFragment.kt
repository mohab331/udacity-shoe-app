package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding

class ShoeListFragment : Fragment() {
    private  val shoeListViewModel: ShoeViewModel by activityViewModels()

    var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        setHasOptionsMenu(true)
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val showListLayout = binding.shoeListLinearLayout
        val  fab = binding.fab
        fab.setOnClickListener {
            onAddToListButtonPressed()
        }
        shoeListViewModel.shoes.observe(viewLifecycleOwner) { shoeList ->
            shoeList.forEach { shoe ->

                val shoeItem =
                    ShoeItemBinding.inflate(layoutInflater, null, false)
                shoeItem.shoeItem = shoe
                showListLayout.addView(shoeItem.root)
            }
        }

        }



    private fun onAddToListButtonPressed(){
        findNavController().navigate(R.id.action_shoeListFragment_to_shoeFragment)
    }


    }