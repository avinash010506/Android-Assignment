@Composable
fun LoginScreen(viewModel: AuthViewModel) {

    val state by viewModel.uiState.collectAsState()

    Column {
        TextField(
            value = state.email,
            onValueChange = viewModel::onEmailChange,
            label = { Text("Email") }
        )

        Button(onClick = { viewModel.sendOtp() }) {
            Text("Send OTP")
        }

        state.error?.let {
            Text(it, color = Color.Red)
        }
    }
}
