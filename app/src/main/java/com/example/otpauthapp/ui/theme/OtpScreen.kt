@Composable
fun OtpScreen(viewModel: AuthViewModel) {

    val state by viewModel.uiState.collectAsState()

    Column {
        Text("OTP sent to ${state.email}")

        TextField(
            value = state.otp,
            onValueChange = viewModel::onOtpChange,
            label = { Text("Enter OTP") }
        )

        Button(onClick = { viewModel.verifyOtp() }) {
            Text("Verify OTP")
        }
    }
}
