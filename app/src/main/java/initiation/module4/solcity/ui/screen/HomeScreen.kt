package initiation.module4.solcity.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import initiation.module4.solcity.R
import initiation.module4.solcity.ui.SolCityScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    val toastOtherCity = { text: String ->
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { navController.navigate(SolCityScreen.LIST_SCREEN.toString()) }
        ) {
            Text(text = "SolCity")
        }
        Button(
            onClick = { toastOtherCity("Working On") }
        ) {
            Text(text = "Other city")
        }
    }
}