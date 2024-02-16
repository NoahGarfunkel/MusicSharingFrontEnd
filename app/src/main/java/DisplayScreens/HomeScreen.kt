import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicsharing.ui.theme.MusicSharingTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingsScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hey There", style = MaterialTheme.typography.titleLarge)

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF00889A)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RectangleBoxContent("Join Group")
            RectangleBoxContent("Find Friends")
            RectangleBoxContent("Explore")

        }
    }
}

//box content
@Composable
fun RectangleBoxContent(boxText: String) {
    RectangleBox(onClick = { /* Handle button click */ }) {
//        Icon(imageVector = Icons.Default.Add, contentDescription = null)
        Text(boxText, style = MaterialTheme.typography.bodyLarge)

    }
}

@Composable
fun RectangleBox(onClick: () -> Unit, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .shadow(
                elevation = 4.dp,
                spotColor = Color(0x40000000),
                ambientColor = Color(0x40000000)
            )
            .width(318.dp)
            .height(94.dp)
            .background(color = Color(0x30FFF3E8), shape = RoundedCornerShape(size = 7.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

//titleContent
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar() {
    TopAppBar(title = {
        Text(
            text = "Welcome to Music Sharing App!",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
    })
}



@Preview(showBackground = true)
@Composable
fun GreetingsScreenPreview() {
    GreetingsScreen()
}

@Composable
fun MyApp() {
    GreetingsScreen()
}

