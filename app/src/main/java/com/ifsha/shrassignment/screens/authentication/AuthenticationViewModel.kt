package com.ifsha.shrassignment.screens.authentication

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val auth: FirebaseAuth
): ViewModel() {
    companion object {
        const val TAG = "AuthenticationViewModel"
    }

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    _isLoggedIn.value = true
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        createAccount(email, password)
                    }
                }
            }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { task ->
                if (task.user != null) {
                    signIn(email,password)
                    Log.d(TAG, "createUserWithEmail:success")
                } else {
                    Log.w(TAG, "createUserWithEmail:failure")
                }
            }
    }
}