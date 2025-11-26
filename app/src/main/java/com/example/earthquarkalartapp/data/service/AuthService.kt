package com.example.earthquarkalartapp.data.service

import com.example.earthquarkalartapp.data.models.UserLogIn
import com.example.earthquarkalartapp.data.models.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegister(user: UserRegister): Task<AuthResult>

    fun userLogin(user: UserLogIn): Task<AuthResult>

    fun createUser(user: UserRegister): Task<Void>

}