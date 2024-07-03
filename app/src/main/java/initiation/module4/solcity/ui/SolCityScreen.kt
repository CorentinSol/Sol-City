package initiation.module4.solcity.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import initiation.module4.solcity.R
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.ui.screen.BottomNavigationBarPlacesType
import initiation.module4.solcity.ui.screen.HomeScreen
import initiation.module4.solcity.ui.screen.PlaceDetailScreen
import initiation.module4.solcity.ui.screen.PlaceListScreen
import initiation.module4.solcity.ui.utils.BottomBarTypeList
import initiation.module4.solcity.ui.utils.BottomBarTypeList.navigationDrawerTypeList
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
    Text(
        text = stringResource(R.string.app_name),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(R.dimen.padding_large))
    )
}

@Composable
fun SolCityListAndDetails(
    placeList: List<Place>,
    currentTab: PlaceType,
    selectedPlace: Place,
    needShowPlaceName: Boolean,
    onClickOnPlaceCard: (Place) -> Unit,
    onClickOnPlaceTypeIcon: (PlaceType) -> Unit,
    onClickOnOpenNavDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) {
        SolCityModalNavigationRail(
            currentPlaceType = currentTab,
            onClickOnPlaceTypeIcon = onClickOnPlaceTypeIcon,
            onClickOnOpenNavDrawer = onClickOnOpenNavDrawer
        )
        PlaceListScreen(
            showBottomNavBar = false,
            selectedPlace = selectedPlace,
            placeList = placeList,
            onClickOnPlaceCard = onClickOnPlaceCard,
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
                needShowPlaceName = needShowPlaceName
            )
        }
    }
}

@Composable
fun SolCityModalNavigationRail(
    currentPlaceType: PlaceType,
    onClickOnPlaceTypeIcon: (PlaceType) -> Unit,
    onClickOnOpenNavDrawer: () -> Unit
) {
    NavigationRail {
        // Button to open the modal drawer
        NavigationRailItem(
            selected = false,
            onClick = onClickOnOpenNavDrawer,
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        )
        navigationDrawerTypeList().forEach { railItem ->
            NavigationRailItem(
                selected = railItem.placeType == currentPlaceType,
                onClick = { onClickOnPlaceTypeIcon(railItem.placeType) },
                icon = { Icon(painter = railItem.icon, contentDescription = null) }
            )
        }
    }
}

@Composable
fun SolCityModalNavigationDrawer(
    currentPlaceType: PlaceType,
    drawerState: DrawerState,
    onClickOnPlaceTypeIcon: (PlaceType) -> Unit,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = false,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(dimensionResource(R.dimen.modal_drawer_width))
            ) {
                SolCityNavigationDrawerHeader()
                HorizontalDivider()

                //FIXME not super clean solution to get "all" the first element
                navigationDrawerTypeList().forEach { navItem ->
                    NavigationDrawerItem(
                        label = { Text(text = navItem.label) },
                        icon = { Icon(painter = navItem.icon, contentDescription = null)},
                        selected = navItem.placeType == currentPlaceType,
                        onClick = { onClickOnPlaceTypeIcon(navItem.placeType) }
                    )
                }
            }
        }
    ) {
        content()
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
        },
        bottomBar = {
            if (navigationType == SolCityNavigationType.BOTTOM_NAVIGATION
                && currentScreen == SolCityScreen.LIST_SCREEN) {
                BottomNavigationBarPlacesType(
                    currentTab = solCityUiState.currentPlaceType,
                    onClickOnPlaceTypeIcon = { placeTypeClicked: PlaceType ->
                        viewModel.onPlaceTypeIconClicked(placeTypeClicked = placeTypeClicked)
                    },
                    navElements = navElements,
                    modifier = Modifier

                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = SolCityScreen.HOME_SCREEN.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            composable(route = SolCityScreen.HOME_SCREEN.name) {
                HomeScreen(
                    navController = navController,
                    navigationType = navigationType
                )
            }
            composable(route = SolCityScreen.LIST_SCREEN.name) {
                PlaceListScreen(
                    showBottomNavBar = true,
                    selectedPlace = solCityUiState.currentPlace,
                    placeList = solCityUiState.currentPlaceList.sortedBy {
                        it.score.value
                    }.reversed(),
                    onClickOnPlaceCard = {
                       viewModel.updateCurrentPlace(it)
                       navController.navigate(SolCityScreen.DETAIL_SCREEN.name)
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
             //   var isDrawerOpen by remember { mutableStateOf(false) }
                SolCityModalNavigationDrawer(
                    currentPlaceType = solCityUiState.currentPlaceType,
                    drawerState =
                    if (solCityUiState.isDrawerOpen) {
                        DrawerState(DrawerValue.Open)
                    } else {
                        DrawerState(DrawerValue.Closed)
                    },
                    onClickOnPlaceTypeIcon = { placeTypeClicked: PlaceType ->
                        viewModel.onPlaceTypeIconClicked(placeTypeClicked = placeTypeClicked)
                        viewModel.updateIsDrawerOpen(false)
                    }
                ) {
                    SolCityListAndDetails(
                        placeList = solCityUiState.currentPlaceList.sortedBy {
                            it.score.value
                        }.reversed(),
                        needShowPlaceName = true,
                        currentTab = solCityUiState.currentPlaceType,
                        selectedPlace = solCityUiState.currentPlace,
                        onClickOnPlaceCard = { newPlace: Place ->
                            viewModel.updateCurrentPlace(newPlace) },
                        onClickOnPlaceTypeIcon = { placeTypeClicked: PlaceType ->
                            viewModel.onPlaceTypeIconClicked(placeTypeClicked = placeTypeClicked)
                        },
                        onClickOnOpenNavDrawer =  { viewModel.updateIsDrawerOpen(true) }
                    )
                }
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