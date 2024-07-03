package initiation.module4.solcity.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import initiation.module4.solcity.R
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
            .fillMaxHeight()
    ) {
        Button(
            onClick = {
                when(navigationType) {
                    SolCityNavigationType.BOTTOM_NAVIGATION ->
                        { navController.navigate(SolCityScreen.LIST_SCREEN.name) }
                    SolCityNavigationType.MODAL_NAVIGATION_DRAWER ->
                        { navController.navigate(SolCityScreen.LIST_AND_DETAILS.name) }
                }
            },
            modifier = Modifier
             .padding(dimensionResource(R.dimen.padding_large))
        ) {
            Text(
                text = "SolCity",
                style = MaterialTheme.typography.displayLarge
            )
        }
        Button(
            onClick = { toastOtherCity("Working On") },
            modifier = Modifier
               // .height(80.dp)
        ) {
            Text(
                text = "Other city",
                style = MaterialTheme.typography.displayLarge
            )
        }
    }
}