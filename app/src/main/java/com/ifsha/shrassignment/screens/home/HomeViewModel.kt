package com.ifsha.shrassignment.screens.home

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {
    private val _user = MutableStateFlow(auth.currentUser)
    val user = _user.asStateFlow()

    fun signOut() {
        auth.signOut()
    }
}