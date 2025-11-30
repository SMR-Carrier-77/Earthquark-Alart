package com.example.earthquarkalartapp.views.login

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.earthquarkalartapp.R
import com.example.earthquarkalartapp.base.BaseFragment
import com.example.earthquarkalartapp.core.DataState
import com.example.earthquarkalartapp.data.models.UserLogIn
import com.example.earthquarkalartapp.databinding.FragmentLogInBinding
import com.example.earthquarkalartapp.isEmpty
import com.example.earthquarkalartapp.views.dashboard.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LogInFragment : BaseFragment<FragmentLogInBinding>(FragmentLogInBinding::inflate) {

    private val viewModel : LogInViewModel by viewModels()

    override fun setListener() {

        with(binding){

            buttonLogInLogIn.setOnClickListener {

                emailLogIn.isEmpty()
                passwordLogIn.isEmpty()

                if (!emailLogIn.isEmpty() && !passwordLogIn.isEmpty()){

                    var user = UserLogIn(
                        email = emailLogIn.text.toString().trim(),
                        password = passwordLogIn.text.toString().trim()
                    )

                    viewModel.userLogIn(user)

                }

            }


            buttonLoginRegistation.setOnClickListener {
                findNavController().navigate(R.id.registerFragment)
            }



        }

    }

    override fun allObserver() {

        viewModel.logIn_Responce.observe(viewLifecycleOwner){

            when(it){
                is DataState.Error -> {
                    loading_progress_dialog.dismiss()
                    Toast.makeText(context , it.message.toString(), Toast.LENGTH_SHORT).show()
                }
                is DataState.Loading -> {
                    loading_progress_dialog.show()
                }
                is DataState.Success -> {
                    loading_progress_dialog.dismiss()
                    Toast.makeText(context , "Log in success!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext(), MainActivity::class.java))
                    requireActivity().finish()
                }
            }

        }


    }

}