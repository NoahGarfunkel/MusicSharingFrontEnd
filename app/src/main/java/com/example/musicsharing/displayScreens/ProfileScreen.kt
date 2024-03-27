import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.DividerDefaults.color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.musicsharing.R



@Composable
fun profileScreen() {
    var name by remember { mutableStateOf("My Name")} // Initial name
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
          .background(color = Color(0xFF00889A))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //EDIT BUTTON
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.End

        ) {
            IconButton(
                onClick = {
                          /* ADD EDIT FUNCTIONALITY HERE */
                          },
                modifier = Modifier
                    .size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Profile",
                    tint =  Color(0xFFFBFFDC) // Cha
                )
            }
        }

        Image(
            painter = painterResource(id = R.drawable.profile_picture), //make dynamic
            contentDescription = "Profile Picture",
            modifier = Modifier
                .padding(top = 5.dp)
                .size(200.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFF309CA9))
                .size(800.dp)
        )
        {
            Text(
                text = "Username",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFFFBFFDC),
                fontSize = 38.sp,
                modifier = Modifier
                    .padding(top = 25.dp)
                    .align(Alignment.TopCenter)

            )

            Text(
                text = name,
                style = MaterialTheme.typography.bodyLarge,
                fontSize = 17.sp,
                color = Color(0xFFFBFFDC),
                modifier = Modifier
                    .padding(top = 80.dp)
                    .align(Alignment.TopCenter)

            )

            Button(
                onClick = { /* ADD LOGOUT FUNCTIONALITY HERE */ },
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .width(1000.dp)
                    .height(50.dp),

                colors = ButtonDefaults.buttonColors(Color(0xFFFBFFDC)) //

            ) {
                Text(
                    text = "Logout",
                    color = Color(0xFF00889A),
                    fontSize = 18.sp,

                )


            }

            }

        }

    }

fun editProfile() {

}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    profileScreen()
}
