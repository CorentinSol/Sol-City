package initiation.module4.solcity.ui

import androidx.lifecycle.ViewModel
import initiation.module4.solcity.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SolCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SolCityUiState())
    val uiState: StateFlow<SolCityUiState> = _uiState

    init {
        initializeUIState()
    }

    fun updateCurrentPlace(newPlace: Place) {
        _uiState.update {
            it.copy(
                currentSelectedPlace = newPlace
            )
        }
    }

    private fun initializeUIState() {

    }
}