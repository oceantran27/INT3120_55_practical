package com.example.flightsearch.ui.screens.flight_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightApplication
import com.example.flightsearch.NavigationDestination
import com.example.flightsearch.data.FlightRepository
import com.example.flightsearch.model.Favorite
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlightViewModel(
    savedStateHandle: SavedStateHandle,
    val flightRepository: FlightRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(FlightUiState())
    val uiState: StateFlow<FlightUiState> = _uiState
    var flightAdded: Boolean by mutableStateOf(false)

    init {
        viewModelScope.launch {

        }
    }

    private fun processFlightList(airportCode: String) {
        viewModelScope.launch {
            val ff = flightRepository.getAllFavoriteFlights().toMutableStateList()
            val aa = flightRepository.getAllAirports().toMutableStateList()
            val departureAirport = aa.first{it.code == airportCode}
            _uiState.update {
                uiState.value.copy(
                    code = airportCode,
                    favoriteList = ff,
                    destinationList = aa,
                    departureAirport = departureAirport
                )
            }
        }
    }

    fun addFavoriteFlight(departureCode: String, destinationCode: String) {
        viewModelScope.launch {
            val favorite: Favorite = flightRepository.getSingleFavorite(departureCode, destinationCode)

            if (favorite == null) {
                val tmp = Favorite(
                    departureCode = departureCode,
                    destinationCode = destinationCode
                )
                flightAdded = true
                flightRepository.insertFavoriteFlight(tmp)
            } else {
                flightAdded = false
                flightRepository.deleteFavoriteFlight(favorite)
            }

            val play = flightRepository.getAllFavoriteFlights()
            _uiState.update {
                uiState.value.copy(
                    favoriteList = play
                )
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightApplication)
                val flightRepository = application.container.flightRepository
                FlightViewModel(
                    this.createSavedStateHandle(),
                    flightRepository = flightRepository
                )
            }
        }
    }
}