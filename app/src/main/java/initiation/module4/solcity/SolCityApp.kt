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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import initiation.module4.solcity.data.provider.Bars
import initiation.module4.solcity.ui.CityAppScreen
import initiation.module4.solcity.ui.SolCityUiState
import initiation.module4.solcity.ui.SolCityViewModel
import initiation.module4.solcity.ui.screen.PlaceDetailScreen
import initiation.module4.solcity.ui.screen.PlaceListScreen

@Composable
fun SolCityApp() {
    val viewModel:SolCityViewModel = viewModel()
    val solCityUiState = viewModel.uiState.collectAsState().value

    CityAppScreen(
        viewModel = viewModel,
        solCityUiState = solCityUiState
    )
}

@Preview (widthDp = 400)
@Composable
fun SolCityAppCompactPreview() {
    //SolCityApp()
}

@Preview (widthDp = 700)
@Composable
fun SolCityAppMediumPreview() {

}

@Preview (widthDp = 1000)
@Composable
fun SolCityAppExtendedPreview() {

}