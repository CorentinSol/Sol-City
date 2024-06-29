package initiation.module4.solcity.ui

import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.data.provider.DefaultPlace

data class SolCityUiState(
    val currentPlace: Place = DefaultPlace.getDefaultPlace(),
    val currentPlaceType: PlaceType = PlaceType.ALL,
    val currentPlaceList: List<Place> = DefaultPlace.getDefaultPlaceList()
)