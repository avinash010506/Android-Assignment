package com.example.otpauth.data

import kotlin.random.Random

object OtpManager {

    private val otpStore = mutableMapOf<String, OtpData>()

    private const val OTP_EXPIRY_MS = 60_000
    private const val MAX_ATTEMPTS = 3

    fun generateOtp(email: String): String {
        val otp = Random.nextInt(100000, 999999).toString()

        otpStore[email] = OtpData(
            otp = otp,
            expiryTime = System.currentTimeMillis() + OTP_EXPIRY_MS,
            attempts = 0
        )

        return otp
    }

    fun validateOtp(email: String, inputOtp: String): Boolean {
        val data = otpStore[email] ?: return false

        if (System.currentTimeMillis() > data.expiryTime) {
            otpStore.remove(email)
            return false
        }

        if (data.attempts >= MAX_ATTEMPTS) {
            otpStore.remove(email)
            return false
        }

        data.attempts++

        return if (data.otp == inputOtp) {
            otpStore.remove(email)
            true
        } else {
            false
        }
    }
}
