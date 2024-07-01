package initiation.module4.solcity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.ui.screen.HomeScreen
import initiation.module4.solcity.ui.screen.PlaceDetailScreen
import initiation.module4.solcity.ui.screen.PlaceListScreen
import initiation.module4.solcity.ui.utils.BottomBarTypeList
import initiation.module4.solcity.ui.utils.PlaceTypeNavigationElements
import initiation.module4.solcity.ui.utils.SolCityNavigationType

enum class SolCityScreen {
    HOME_SCREEN, LIST_SCREEN, DETAIL_SCREEN, LIST_AND_DETAILS
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
fun SolCityNavigationDrawerHeader() {
    //TODO
}

@Composable
fun SolCityNavigationDrawerItem() {
    //TODO
}

@Composable
fun SolCityListAndDetails(
    placeList: List<Place>,
    currentTab: PlaceType,
    selectedPlace: Place,
    needShowPlaceName: Boolean,
    navElements: List<PlaceTypeNavigationElements>,
    onClickOnPlaceCard: (Place) -> Unit,
    onClickOnPlaceTypeIcon: (PlaceType) -> Unit,
    modifier: Modifier = Modifier
) {
        Row(modifier = modifier) {
            PlaceListScreen(
                showBottomNavBar = false,
                selectedPlace = selectedPlace,
                placeList = placeList,
                currentTab = currentTab,
                navElements = navElements,
                onClickOnPlaceCard = onClickOnPlaceCard,
                onClickOnPlaceTypeIcon = onClickOnPlaceTypeIcon,
                modifier = Modifier.weight(2F)
            )
            Surface(
                color = MaterialTheme.colorScheme.inversePrimary,
                shape = CardDefaults.shape,
                modifier = Modifier
                    .weight(2F)
                    .padding(dimensionResource(R.dimen.padding_large))
            ) {
            PlaceDetailScreen(
                place = selectedPlace,
                needShowPlaceName = needShowPlaceName,

            )
        }
    }

}

@Composable
fun SolCityPermanentNavigationDrawer() {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(
                //TODO Width
                drawerContentColor = MaterialTheme.colorScheme.inverseOnSurface
            ) {
                SolCityNavigationDrawerHeader()
            }
        }
    ) {
        
    }
}

@Composable
fun CityAppScreen(
    navigationType: SolCityNavigationType,
    viewModel: SolCityViewModel,
    solCityUiState: SolCityUiState,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    // FIXME I don't understand why topAppBar doesn't recompose without this
    val currentScreen = SolCityScreen.valueOf(
        backStackEntry?.destination?.route ?: SolCityScreen.HOME_SCREEN.toString()
    )

    val navElements = BottomBarTypeList.navigationBottomBarTypeList()

    Scaffold(
        topBar = {
            if (navigationType == SolCityNavigationType.BOTTOM_NAVIGATION
                || currentScreen == SolCityScreen.HOME_SCREEN) {
                SolCityTopAppBar(
                    //FIXME List name
                    pageTitle =

                    when(currentScreen) {
                        SolCityScreen.valueOf(SolCityScreen.LIST_SCREEN.name)
                        -> stringResource(solCityUiState.currentPlaceType.category)

                        SolCityScreen.valueOf(SolCityScreen.DETAIL_SCREEN.name)
                        -> solCityUiState.currentPlace.name

                        else -> stringResource(R.string.app_name)
                    },
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            } // else no top app bar needed
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
                    navController = navController,
                    navigationType = navigationType
                )
            }
            composable(route = SolCityScreen.LIST_SCREEN.name) {
                PlaceListScreen(
                    showBottomNavBar = true,
                    selectedPlace = solCityUiState.currentPlace,
                    currentTab = solCityUiState.currentPlaceType,
                    placeList = solCityUiState.currentPlaceList.sortedBy {
                        it.score.value
                    }.reversed(),
                    onClickOnPlaceCard = {
                       viewModel.updateCurrentPlace(it)
                       navController.navigate(SolCityScreen.DETAIL_SCREEN.name)
                    },
                    navElements = navElements,
                    onClickOnPlaceTypeIcon = { placeTypeClicked: PlaceType ->
                        viewModel.onPlaceTypeIconClicked(placeTypeClicked = placeTypeClicked)
                    }
                )
            }
            composable(route = SolCityScreen.DETAIL_SCREEN.name) {
                PlaceDetailScreen(
                    place = solCityUiState.currentPlace,
                    needShowPlaceName = false
                )
            }
            composable(route = SolCityScreen.LIST_AND_DETAILS.name) {
                SolCityListAndDetails(
                    placeList = solCityUiState.currentPlaceList.sortedBy {
                        it.score.value
                    }.reversed(),
                    needShowPlaceName = true,
                    currentTab = solCityUiState.currentPlaceType,
                    selectedPlace = solCityUiState.currentPlace,
                    navElements = navElements,
                    onClickOnPlaceCard = { newPlace: Place ->
                        viewModel.updateCurrentPlace(newPlace) },
                    onClickOnPlaceTypeIcon = { placeTypeClicked: PlaceType ->
                        viewModel.onPlaceTypeIconClicked(placeTypeClicked = placeTypeClicked)
                    }
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
fun CityAppScreenExpandedPreview() {

}