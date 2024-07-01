package initiation.module4.solcity

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import initiation.module4.solcity.ui.CityAppScreen
import initiation.module4.solcity.ui.SolCityViewModel
import initiation.module4.solcity.ui.utils.SolCityNavigationType

@Composable
fun SolCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val viewModel:SolCityViewModel = viewModel()
    val solCityUiState = viewModel.uiState.collectAsState().value
    val navigationType: SolCityNavigationType
    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = SolCityNavigationType.BOTTOM_NAVIGATION
        }
        WindowWidthSizeClass.Medium -> {
            navigationType = SolCityNavigationType.NAVIGATION_RAIL
        }
        WindowWidthSizeClass.Expanded -> {
            navigationType = SolCityNavigationType.PERMANENT_NAVIGATION_DRAWER
        } else -> {
        navigationType = SolCityNavigationType.BOTTOM_NAVIGATION
        }
    }
    // FIXME Landscape in compact
    CityAppScreen(
        navigationType = navigationType,
        viewModel = viewModel,
        solCityUiState = solCityUiState
    )
}

@Preview (widthDp = 400)
@Composable
fun SolCityAppCompactPreview() {
    SolCityApp(
        windowSize = WindowWidthSizeClass.Compact
    )
}

@Preview (widthDp = 700)
@Composable
fun SolCityAppMediumPreview() {
    SolCityApp(
        windowSize = WindowWidthSizeClass.Medium
    )
}

@Preview (widthDp = 1000)
@Composable
fun SolCityAppExpandedPreview() {
    SolCityApp(
        windowSize = WindowWidthSizeClass.Expanded
    )
}