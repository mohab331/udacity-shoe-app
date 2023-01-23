package com.udacity.shoestore.screens.login
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.udacity.shoestore.models.UserModel


class LoginViewModel : ViewModel() {

    fun  login(user: UserModel): Boolean {
        if(isUserNameValid(email = user.email) && isPasswordValid(password = user.password)) {
            return true
        }
        return  false
    }


    private fun isUserNameValid(email: String): Boolean {
        return if (email.isNotBlank() && email.contains("@")) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }
}