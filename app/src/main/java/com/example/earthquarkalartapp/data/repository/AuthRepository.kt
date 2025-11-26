package com.example.earthquarkalartapp.data.repository

import com.example.earthquarkalartapp.data.models.UserLogIn
import com.example.earthquarkalartapp.data.models.UserRegister
import com.example.earthquarkalartapp.data.service.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import jakarta.inject.Inject

class AuthRepository @Inject constructor(
    private val jjAuth : FirebaseAuth,
    private val db : FirebaseFirestore
): AuthService {

    override fun userRegister(user: UserRegister) : Task<AuthResult> {

        return jjAuth.createUserWithEmailAndPassword(user.email , user.password)

    }

    override fun userLogin(user: UserLogIn): Task<AuthResult> {

        return jjAuth.signInWithEmailAndPassword(user.email , user.password)

    }

    override fun createUser(user: UserRegister) : Task<Void> {

        return db.collection("User").document(user.userId).set(user)

    }

}