package com.android.holyeat.ui.auth.sign_in

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(val authRepository: AuthRepository) : ViewModel() {

    private val _status = MutableLiveData<Boolean>()
    val status: LiveData<Boolean> get() = _status

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun login(email: String?, password: String?) {
        viewModelScope.launch(Dispatchers.IO){
            authRepository.login(email?: "", password?: "") {
                if(it.first){
                    _status.postValue(it.first)
                }else{
                    _error.postValue(it.second)
                }
            }
        }
    }
}