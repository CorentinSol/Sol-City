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

    init {
        //FIXME default place when launching is not the first of the displayed list
        initialize(DefaultPlace.getDefaultPlaceList())
    }

    fun updateIsDrawerOpen(newIsDrawerOpen: Boolean) {
        _uiState.update {
            it.copy(
                isDrawerOpen = newIsDrawerOpen
            )
        }
    }

    private fun initialize(placeListToUse: List<Place>) {
        // Select place List
        setCurrentPlaceList(placeListToUse)
        // Order list by descending score
        updateCurrentPlaceList(PlaceType.ALL)
        // Set selected place to the first item of the list
        updateCurrentPlace(_uiState.value.currentPlaceList.elementAt(0))
    }

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

    private fun updateCurrentPlaceType(newPlaceType: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceType = newPlaceType
            )
        }
    }

    private fun updateCurrentPlaceList(placeTypeFilter: PlaceType) {
        _uiState.update {
            it.copy(
                currentPlaceList = if (placeTypeFilter == PlaceType.ALL) {
                    DefaultPlace.getDefaultPlaceList().sortedByDescending { it.score }
                } else {
                    DefaultPlace.getDefaultPlaceList()
                        .filter { place: Place ->
                            place.type == _uiState.value.currentPlaceType
                        }.sortedByDescending { it.score }
                }
            )
        }
    }

    private fun setCurrentPlaceList(placeList: List<Place>) {
        _uiState.update {
            it.copy(
                currentPlaceList = placeList.sortedByDescending { it.score }
            )
        }
    }
}