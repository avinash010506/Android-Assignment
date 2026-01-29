import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.otpauth.viewmodel.AuthViewModel
import com.example.otpauth.ui.LoginScreen
import com.example.otpauth.ui.theme.OtpAuthTheme

class MainActivity : ComponentActivity() {

    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            OtpAuthTheme {
                val state by viewModel.uiState.collectAsState()

                when {
                    state.isLoggedIn -> {
                        SessionScreen(viewModel)
                    }
                    state.isOtpSent -> {
                        OtpScreen(viewModel)
                    }
                    else -> {
                        LoginScreen(viewModel)
                    }
                }
            }
        }
    }
}
