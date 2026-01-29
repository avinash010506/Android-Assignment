package com.example.otpauth.viewmodel

data class AuthState(
    val email: String = "",
    val otp: String = "",
    val isOtpSent: Boolean = false,
    val isLoggedIn: Boolean = false,
    val error: String? = null
)
