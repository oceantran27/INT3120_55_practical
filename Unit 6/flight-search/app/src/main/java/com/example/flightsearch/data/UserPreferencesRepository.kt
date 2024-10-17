package com.example.flightsearch.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.flightsearch.data.UserPreferencesKeys.SEARCH_VALUE
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

data class UserPreferences(
    val searchValues: String = "",
)

object UserPreferencesKeys {
    val SEARCH_VALUE = stringPreferencesKey("search_value")
}

class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {
    suspend fun updateUserPreferences(
        searchValues: String
    ) {
        dataStore.edit { preferences ->
            preferences[SEARCH_VALUE] = searchValues
        }
    }

    val userPreferencesFlow: Flow<UserPreferences> = dataStore.data
        .catch { exeption ->
            if (exeption is IOException) {

            } else {
                throw exeption
            }
        }
        .map { preferences ->
            UserPreferences(
                searchValues = preferences[SEARCH_VALUE] ?: "",
            )
        }
}