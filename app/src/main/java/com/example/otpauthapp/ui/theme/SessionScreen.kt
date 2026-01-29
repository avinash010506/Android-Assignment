@Composable
fun SessionScreen(viewModel: AuthViewModel) {

    Column {
        Text("Logged In")

        Button(onClick = { viewModel.logout() }) {
            Text("Logout")
        }
    }
}
