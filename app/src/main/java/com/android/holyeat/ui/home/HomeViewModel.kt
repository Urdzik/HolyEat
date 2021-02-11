package com.android.holyeat.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.repository.AuthRepository
import com.android.holyeat.data.repository.nutritionist.NutritionistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val nutritionistRepository: NutritionistRepository) : ViewModel() {

  init {
      viewModelScope.launch {
          nutritionistRepository.getNutritionists().collect {
              Log.d("TAG", it.joinToString())
          }
      }
  }
}