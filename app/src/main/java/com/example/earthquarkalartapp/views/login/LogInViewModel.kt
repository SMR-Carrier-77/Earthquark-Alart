package com.example.earthquarkalartapp.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earthquarkalartapp.core.DataState
import com.example.earthquarkalartapp.data.models.UserLogIn
import com.example.earthquarkalartapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val userAuth : AuthRepository
): ViewModel() {



    private val logInResponce = MutableLiveData<DataState<UserLogIn>>()

    val logIn_Responce : LiveData<DataState<UserLogIn>> = logInResponce

    fun userLogIn(user : UserLogIn){
        logInResponce.postValue(DataState.Loading())

        userAuth.userLogin(user).addOnSuccessListener {
            logInResponce.postValue(DataState.Success(user))
        }.addOnFailureListener {
            logInResponce.postValue(DataState.Error(it.message.toString()))
        }

    }

}