package com.example.otpauth.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AuthState())
    val uiState: StateFlow<AuthState> = _uiState

    fun onEmailChange(value: String) {
        _uiState.value = _uiState.value.copy(email = value)
    }

    fun sendOtp() {
        _uiState.value = _uiState.value.copy(isOtpSent = true)
    }

    fun onOtpChange(value: String) {
        _uiState.value = _uiState.value.copy(otp = value)
    }

    fun verifyOtp() {
        // Temporary logic (you’ll improve later)
        _uiState.value = _uiState.value.copy(isLoggedIn = true)
    }

    fun logout() {
        _uiState.value = AuthState()
    }
}
