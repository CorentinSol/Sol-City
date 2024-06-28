package initiation.module4.solcity.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.provider.ConcertHalls
import initiation.module4.solcity.data.provider.DefaultPlace
import initiation.module4.solcity.ui.screen.HomeScreen
import initiation.module4.solcity.ui.screen.PlaceDetailScreen
import initiation.module4.solcity.ui.screen.PlaceListScreen

enum class SolCityScreen {
    HOME_SCREEN, LIST_SCREEN, DETAIL_SCREEN
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolCityTopAppBar(
    pageTitle: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = { }
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
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.accessibility_back_navigation),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        },
    )
}

@Composable
fun CityAppScreen(
    viewModel: SolCityViewModel,
    solCityUiState: SolCityUiState,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    // FIXME I don't understand why topAppBar doesn't recompose without this
    val currentScreen = SolCityScreen.valueOf(
        backStackEntry?.destination?.route ?: SolCityScreen.HOME_SCREEN.toString()
    )

    Scaffold(
        topBar = {
            SolCityTopAppBar(
                //FIXME List name
                pageTitle =  when(currentScreen) {
                    SolCityScreen.valueOf(SolCityScreen.LIST_SCREEN.name)
                        -> solCityUiState.currentPlaceList.toString()
                    SolCityScreen.valueOf(SolCityScreen.DETAIL_SCREEN.name)
                        -> solCityUiState.currentSelectedPlace.name
                    else -> stringResource(R.string.app_name)
                },
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = SolCityScreen.HOME_SCREEN.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SolCityScreen.HOME_SCREEN.name) {
                HomeScreen(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController
                )
            }
            composable(route = SolCityScreen.LIST_SCREEN.name) {
                PlaceListScreen(
                    placeList = solCityUiState.currentPlaceList,
                    onClick = {
                       viewModel.updateCurrentPlace(it)
                       navController.navigate(SolCityScreen.DETAIL_SCREEN.name)
                    }
                )
            }
            composable(route = SolCityScreen.DETAIL_SCREEN.name) {
                PlaceDetailScreen(
                    place = solCityUiState.currentSelectedPlace
                )
            }
        }
    }
}

@Preview(widthDp = 400)
@Composable
fun CityAppScreenCompactPreview() {
  //  CityAppScreen()
}

@Preview(widthDp = 700)
@Composable
fun CityAppScreenMediumPreview() {

}

@Preview(widthDp = 1000)
@Composable
fun CityAppScreenExtendedPreview() {

}