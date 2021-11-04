package brian.big.quotelegend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.ConstraintLayout
import brian.big.quotelegend.ui.theme.QuoteLegendTheme
import brian.big.quotelegend.ui.theme.navy

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuoteLegendTheme {
               Surface(color = MaterialTheme.colors.background) {
                    App()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun App(){
    Scaffold(topBar = { AppTopBar()}, bottomBar = { AppBottomBar()}, floatingActionButton = {FloatingActionBtn()}) {

    }
}

@Preview("AppTopBar")
@Composable
fun AppTopBar(){
    TopAppBar(elevation = 10.dp) {
    }
}

@Preview("AppBottomBar")
@Composable
fun AppBottomBar() {

    var selectedState = remember {
        "home"
    }

    BottomAppBar(
        elevation = 10.dp,
        cutoutShape = RoundedCornerShape(50)
    ) {
        Spacer(Modifier.weight(1f, true))
        IconButton(onClick = {
            selectedState = "home"
        }) {
            Icon(Icons.Filled.Home,"Home")
        }
        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(onClick = {
            selectedState = "favorites"
        }) {
            Icon(Icons.Filled.Favorite,"Favorites")
        }
        Spacer(Modifier.weight(1f, true))

        IconButton(onClick = {
            selectedState = "profile"
        }) {
            Icon(Icons.Filled.VerifiedUser,"Profile")
        }
        Spacer(Modifier.weight(1f, true))
    }
}

@Preview()
@Composable
fun FloatingActionBtn(){
    FloatingActionButton(onClick = { /*TODO*/ },
        shape = RoundedCornerShape(50), contentColor = Color.White, backgroundColor = navy) {
        Icon(Icons.Filled.Add, contentDescription = "add")
    }
}

@Preview("Quote card preview")
@Composable
fun QuoteCard(modifier: Modifier = Modifier){
    Row(
        modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()){
        Surface {
            Image(imageVector = Icons.Rounded.FormatQuote,
                contentDescription = "quote icon", modifier.size(50.dp))
            Spacer(modifier.width(8.dp))
        }
    }
}
