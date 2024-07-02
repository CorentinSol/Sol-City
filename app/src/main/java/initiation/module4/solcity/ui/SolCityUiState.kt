package initiation.module4.solcity.ui

import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.data.provider.DefaultPlace

data class SolCityUiState(
    val currentPlaceList: List<Place> = DefaultPlace.getDefaultPlaceList(),
    val currentPlace: Place = currentPlaceList.first(),
    val currentPlaceType: PlaceType = PlaceType.ALL,
    val isDrawerOpen: Boolean = false
)