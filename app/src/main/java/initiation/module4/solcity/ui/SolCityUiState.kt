package initiation.module4.solcity.ui

import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.data.provider.DefaultPlace

data class SolCityUiState(
    val currentSelectedPlace: Place = DefaultPlace.getDefaultPlace(),
    val currentTypeListName: String = PlaceType.ALL.name,
    val currentPlaceList: List<Place> = DefaultPlace.getDefaultPlaceList()
)