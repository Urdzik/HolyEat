package com.android.holyeat.ui.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.model.NutritionistModel
import com.android.holyeat.data.repository.nutritionist.NutritionistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(private val nutritionistRepository: NutritionistRepository) : ViewModel() {

    private val _nutritionists = MutableLiveData<List<NutritionistModel>>()
    val nutritionists: LiveData<List<NutritionistModel>> get() = _nutritionists

    init {
        viewModelScope.launch(Dispatchers.IO){
            nutritionistRepository.getNutritionists().collect {
                _nutritionists.postValue(it)
            }
        }
    }
}