package com.android.holyeat.ui.nutritionist

import androidx.lifecycle.ViewModel
import com.android.holyeat.data.repository.nutritionist.NutritionistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NutritionistViewModel @Inject constructor(private val nutritionistRepository: NutritionistRepository) :
    ViewModel() {


}