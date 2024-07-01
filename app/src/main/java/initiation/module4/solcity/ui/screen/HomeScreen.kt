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
import androidx.navigation.NavController
import initiation.module4.solcity.ui.SolCityScreen
import initiation.module4.solcity.ui.utils.SolCityNavigationType

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigationType: SolCityNavigationType
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
            onClick = {
                when(navigationType) {
                    SolCityNavigationType.BOTTOM_NAVIGATION ->
                        { navController.navigate(SolCityScreen.LIST_SCREEN.toString()) }
                    // TODO Navigation rail
                    SolCityNavigationType.PERMANENT_NAVIGATION_DRAWER ->
                        { navController.navigate(SolCityScreen.LIST_AND_DETAILS.toString()) }
                    else -> // Other
                    { navController.navigate(SolCityScreen.LIST_SCREEN.toString()) }
                }
            }

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