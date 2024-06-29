package initiation.module4.solcity.ui

import androidx.lifecycle.ViewModel
import initiation.module4.solcity.data.Place
import initiation.module4.solcity.data.PlaceType
import initiation.module4.solcity.data.provider.DefaultPlace
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SolCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SolCityUiState())
    val uiState: StateFlow<SolCityUiState> = _uiState

    private fun getPlacesOfAType(placeTypeFilter: PlaceType) : List<Place> {
        return DefaultPlace.getDefaultPlaceList()
            .filter {
                it.type == placeTypeFilter
            }
    }

    fun updateCurrentPlace(newPlace: Place) {
        _uiState.update {
            it.copy(
                currentPlace = newPlace,
            )
        }
    }

    fun onPlaceTypeIconClicked(placeTypeClicked: PlaceType) {
        updateCurrentPlaceType(placeTypeClicked)
        updateCurrentPlaceList(_uiState.value.currentPlaceType)
    }

    fun updateCurrentPlaceType(newPlaceType: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceType = newPlaceType
            )
        }
    }

    fun updateCurrentPlaceList(placeTypeFilter: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceList = if (placeTypeFilter == PlaceType.ALL) {
                    DefaultPlace.getDefaultPlaceList()
                } else {
                    DefaultPlace.getDefaultPlaceList()
                        .filter { place: Place ->
                            place.type == _uiState.value.currentPlaceType
                        }
                }
            )
        }
    }
}