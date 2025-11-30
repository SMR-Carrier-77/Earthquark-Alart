package com.example.earthquarkalartapp.views.starter

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.earthquarkalartapp.R
import com.example.earthquarkalartapp.views.dashboard.MainActivity
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {
    @Inject
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)



    }

    override fun onStart() {
        super.onStart()
        var curretUser = auth.currentUser

        if (curretUser!=null){

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }
    }


}