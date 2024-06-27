package initiation.module4.solcity

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import initiation.module4.solcity.data.provider.Bars
import initiation.module4.solcity.ui.screen.PlaceDetailScreen
import initiation.module4.solcity.ui.screen.PlaceListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolCityTopAppBar(
    pageTitle: String
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = pageTitle,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.primary),
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.accessibility_back_navigation),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
    )
}

@Composable
fun SolCityApp() {
    Scaffold(
        topBar = {SolCityTopAppBar("FIXME") }
    ) { innerPadding ->
       /* PlaceDetailScreen(
            place = Bars.getAllBars().get(0),
            modifier = Modifier.padding(innerPadding)
        ) */
        PlaceListScreen(
            placeList = Bars.getAllBars(),
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