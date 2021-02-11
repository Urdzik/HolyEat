package com.android.holyeat.ui.auth.create_user.other_information

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateOtherInformationViewModel @Inject constructor(val authRepository: AuthRepository) : ViewModel() {

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> get() = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> get() = _password

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> get() = _status

    fun login(){
        viewModelScope.launch(Dispatchers.IO){
            authRepository.login(email.value?: "", password.value?: "") {
                _status.postValue(it.first)
            }
        }
    }
}