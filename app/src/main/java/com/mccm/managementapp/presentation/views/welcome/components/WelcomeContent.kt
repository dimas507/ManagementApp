import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents.WelcomeBoxHeader
import com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents.WelcomeCard
import com.mccm.managementapp.presentation.views.welcome.components.welcomecontentcomponents.WelcomeDownCard


@Composable
fun WelcomeContent() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    {
        Column {
            WelcomeBoxHeader()
            WelcomeCard()
            WelcomeDownCard()
        }
    }
}