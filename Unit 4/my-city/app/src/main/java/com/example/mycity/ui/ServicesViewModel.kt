/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.LocalServicesDataProvider
import com.example.mycity.model.Service
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/**
 * View Model for Sports app
 */
class SportsViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        SportsUiState(
            sportsList = LocalServicesDataProvider.getSportsData(),
            currentService = LocalServicesDataProvider.getSportsData().getOrElse(0) {
                LocalServicesDataProvider.defaultSport
            }
        )
    )
    val uiState: StateFlow<SportsUiState> = _uiState

    fun updateCurrentSport(selectedService: Service) {
        _uiState.update {
            it.copy(currentService = selectedService)
        }
    }

    fun navigateToListPage() {
        _uiState.update {
            it.copy(isShowingListPage = true)
        }
    }


    fun navigateToDetailPage() {
        _uiState.update {
            it.copy(isShowingListPage = false)
        }
    }
}

data class SportsUiState(
    val sportsList: List<Service> = emptyList(),
    val currentService: Service = LocalServicesDataProvider.defaultSport,
    val isShowingListPage: Boolean = true
)