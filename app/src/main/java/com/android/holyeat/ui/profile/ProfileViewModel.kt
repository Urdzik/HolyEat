package com.android.holyeat.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.holyeat.data.model.UserModel
import com.android.holyeat.data.repository.auth.AuthRepository
import com.android.holyeat.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    private val _user = MutableLiveData<UserModel>()
    val user: LiveData<UserModel> get() = _user

    init {
        viewModelScope.launch(Dispatchers.IO){
            userRepository.getUser().collect {
                _user.postValue(it)
            }
        }
    }

}