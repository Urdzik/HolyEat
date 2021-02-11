package com.android.holyeat.ui.auth.create_user.other_information

import android.text.BoringLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.model.UserModel
import com.android.holyeat.data.repository.auth.AuthRepository
import com.android.holyeat.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.function.BooleanSupplier
import javax.inject.Inject

@HiltViewModel
class CreateOtherInformationViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {


    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> get() = _status

    fun setUser(data: UserModel) {
        viewModelScope.launch(Dispatchers.IO){
            userRepository.setUser(data)
            _status.postValue(true)
        }
    }

}
