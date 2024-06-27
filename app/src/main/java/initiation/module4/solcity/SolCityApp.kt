package initiation.module4.solcity

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import initiation.module4.solcity.data.provider.Bars
import initiation.module4.solcity.ui.screen.PlaceDetailScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolCityTopAppBar(
    pageTitle: String
) {
    CenterAlignedTopAppBar(
        title = { /*TODO*/ },
     //   navigationIcon = ,
    //    colors =
    )
}

@Composable
fun SolCityApp() {
    Scaffold(
     //   topBar = { SolCityTopAppBar() }
    ) { innerPadding ->
        PlaceDetailScreen(
            place = Bars.getAllBars().get(0),
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Preview (widthDp = 400)
@Composable
fun SolCityAppCompactPreview() {
    SolCityApp()
}

@Preview (widthDp = 700)
@Composable
fun SolCityAppMediumPreview() {

}

@Preview (widthDp = 1000)
@Composable
fun SolCityAppExtendedPreview() {

}