package initiation.module4.solcity.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import initiation.module4.solcity.ui.SolCityScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
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
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Autre")
        }
    }
}