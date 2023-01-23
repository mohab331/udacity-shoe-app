package com.udacity.shoestore.screens.onBoarding.instruction

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.OnBoardingInstructionModel

class InstructionViewModel : ViewModel() {
    val instructionsList  = listOf<OnBoardingInstructionModel>(
        OnBoardingInstructionModel(
            title = "Step 1",
            instructionData = " Tap + icon to add a new shoe item",
        ),
        OnBoardingInstructionModel(
            title = "Step 2",
            instructionData = "Tap the Save Button to save the shoe",
        ),
    )

}