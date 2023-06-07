import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.mccm.managementapp.R
import com.mccm.managementapp.presentation.components.DefaultButton
import com.mccm.managementapp.presentation.ui.theme.Gray500
import com.mccm.managementapp.presentation.ui.theme.Indigo900
import com.mccm.managementapp.presentation.ui.theme.ManagementAppTheme


@Composable
fun WelcomeContent() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()))
    {
        Column() {
            WelcomeBoxHeader()
            WelcomeCard()
        }
    }
}

@Composable
fun WelcomeBoxHeader(){
Column(modifier = Modifier
    .fillMaxWidth()
    .padding(20.dp)) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier,
            painter = painterResource(id = R.drawable.user_1),
            contentDescription = "User")
        Spacer(modifier = Modifier.width(15.dp))
        Column {
            Text(
                text = "Username",
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "School name",
                color = Gray500,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light
            )
        }
    }
    Spacer(modifier = Modifier.width(15.dp))
    Text(
        modifier = Modifier.padding(start = 20.dp),
        text = "Welcome!",
        color = Indigo900,
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold)
}
}

@Composable
fun WelcomeCard(){
    Spacer(modifier = Modifier.width(15.dp))
    Card(modifier = Modifier
        .padding(start = 30.dp, end = 30.dp)
        .fillMaxWidth(),
        border = BorderStroke(3.dp, Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            DefaultButton(text = "Begginer", onClick = { /*TODO*/ }, modifier = Modifier
                .size(width = 140.dp, height = 40.dp))
            Row() {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp, top = 50.dp)
                        .wrapContentWidth(Alignment.Start),
                    text = "Animals",
                    color = Indigo900,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Box(modifier = Modifier){
                    Image(
                        modifier = Modifier
                            .zIndex(0f)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.blue_circle),
                        contentDescription = "User")
                    Image(
                        modifier = Modifier
                            .zIndex(1f)
                            .wrapContentWidth(Alignment.End),
                        painter = painterResource(id = R.drawable.teacher_learning),
                        contentDescription = "User")
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeContent() {
    ManagementAppTheme {
        WelcomeContent()
    }
}

