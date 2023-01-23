package com.udacity.shoestore.screens.onBoarding.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {
    private lateinit var instructionViewModel: InstructionViewModel

    private var _binding: FragmentInstructionsBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInstructionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instructionViewModel = InstructionViewModel()
        val nextButton = binding.nextButton

        binding.firstInstruction = instructionViewModel.instructionsList[0]
        binding.secondInstruction = instructionViewModel.instructionsList[1]


        nextButton.setOnClickListener{
                onNextButtonPressed()
        }


    }
    private fun onNextButtonPressed(){
        findNavController().navigate(R.id.action_instructionsFragment_to_shoeListFragment)

    }


}