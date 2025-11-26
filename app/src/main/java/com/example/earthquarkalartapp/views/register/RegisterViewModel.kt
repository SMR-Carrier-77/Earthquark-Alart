package com.example.earthquarkalartapp.views.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.earthquarkalartapp.core.DataState
import com.example.earthquarkalartapp.data.models.UserRegister
import com.example.earthquarkalartapp.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private var auth : AuthRepository
) : ViewModel() {

    private var _registationResponce = MutableLiveData<DataState<UserRegister>>()

    var registation_responce : LiveData<DataState<UserRegister>> = _registationResponce

    fun userRegistation(user : UserRegister){

        _registationResponce.postValue(DataState.Loading())

        auth.userRegister(user).addOnSuccessListener {

            it.user?.let{createdUser->
                user.userId = createdUser.uid

                auth.createUser(user).addOnSuccessListener {
                    _registationResponce.postValue(DataState.Success(user))
                }.addOnFailureListener {
                    _registationResponce.postValue(DataState.Error(it.message.toString()))
                }
            }

        }.addOnFailureListener {
            _registationResponce.postValue(DataState.Error(it.message))
        }

    }


}