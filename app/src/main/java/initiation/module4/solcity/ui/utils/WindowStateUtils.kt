package initiation.module4.solcity.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import initiation.module4.solcity.R
import initiation.module4.solcity.data.PlaceType

enum class SolCityNavigationType {
    BOTTOM_NAVIGATION, MODAL_NAVIGATION_DRAWER
}

data class PlaceTypeNavigationElements(
    val label: String,
    val icon: Painter,
    val placeType: PlaceType
)

object BottomBarTypeList {

    @Composable
    fun navigationBottomBarTypeList(): List<PlaceTypeNavigationElements> {
        return listOf(
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_bar),
                icon = painterResource(R.drawable.sports_bar_24dp),
                placeType = PlaceType.BAR
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_concert_hall),
                icon = painterResource(R.drawable.music_note_24dp),
                placeType = PlaceType.CONCERT_HALL
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_all),
                icon = painterResource(R.drawable.select_all_24dp),
                placeType = PlaceType.ALL
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_restaurant),
                icon = painterResource(R.drawable.restaurant_24dp),
                placeType = PlaceType.RESTAURANT
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_other),
                icon = painterResource(R.drawable.more_horiz_24dp),
                placeType = PlaceType.OTHER
            )
        )
    }

    @Composable
    fun navigationDrawerTypeList(): List<PlaceTypeNavigationElements> {
        return listOf(
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_all),
                icon = painterResource(R.drawable.select_all_24dp),
                placeType = PlaceType.ALL
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_bar),
                icon = painterResource(R.drawable.sports_bar_24dp),
                placeType = PlaceType.BAR
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_concert_hall),
                icon = painterResource(R.drawable.music_note_24dp),
                placeType = PlaceType.CONCERT_HALL
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_restaurant),
                icon = painterResource(R.drawable.restaurant_24dp),
                placeType = PlaceType.RESTAURANT
            ),
            PlaceTypeNavigationElements(
                label = stringResource(R.string.label_other),
                icon = painterResource(R.drawable.more_horiz_24dp),
                placeType = PlaceType.OTHER
            )
        )
    }
}

