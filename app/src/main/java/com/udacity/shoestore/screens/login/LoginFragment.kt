package com.udacity.shoestore.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.models.UserModel

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel = LoginViewModel()

        val emailEditText = binding.emailEditTxt
        val passwordEditText = binding.passwordEditTxt
        val loginButton = binding.loginButton
        val registerButton = binding.registerButton


        loginButton.setOnClickListener {
            val isLoggedInSuccessfully: Boolean = loginViewModel.login(
                user = UserModel(
                    email = emailEditText.text.toString(),
                    password = passwordEditText.text.toString()
                )
            )
            if (isLoggedInSuccessfully) {
                loginSucceeded()
            } else {
               showLoginFailed(view , R.string.login_failed)
            }
        }
        registerButton.setOnClickListener{
           loginSucceeded()
        }
    }

    private  fun loginSucceeded(){
        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

    private fun showLoginFailed(view: View, @StringRes errorString: Int) {
        Snackbar.make(view, getString(errorString),
            Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}