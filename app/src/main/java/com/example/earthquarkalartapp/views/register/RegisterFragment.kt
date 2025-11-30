package com.example.earthquarkalartapp.views.register

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.earthquarkalartapp.R
import com.example.earthquarkalartapp.base.BaseFragment
import com.example.earthquarkalartapp.core.DataState
import com.example.earthquarkalartapp.data.models.UserRegister
import com.example.earthquarkalartapp.databinding.FragmentRegisterBinding
import com.example.earthquarkalartapp.isEmpty
import com.example.earthquarkalartapp.views.dashboard.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel : RegisterViewModel by viewModels ()

    override fun setListener() {

        with(binding){

            buttonRegisterLogIn.setOnClickListener {

                findNavController().navigate(R.id.logInFragment)

            }

            buttonRegisterRegistation.setOnClickListener {

                nameRegister.isEmpty()
                emailRegister.isEmpty()
                passwordRegister.isEmpty()

                if(!nameRegister.isEmpty() && !emailRegister.isEmpty() && !passwordRegister.isEmpty()){

                    var user = UserRegister(
                        userId = "",
                        name = nameRegister.text.toString().trim(),
                        email = emailRegister.text.toString().trim(),
                        password = passwordRegister.text.toString().trim()
                    )

                    viewModel.userRegistation(user)


                }

            }

        }
    }

    override fun allObserver() {

        viewModel.registation_responce.observe(viewLifecycleOwner){

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
                    Toast.makeText(context , "Registation Success!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(requireContext() , MainActivity::class.java))
                    requireActivity().finish()

                }
            }

        }

    }

}