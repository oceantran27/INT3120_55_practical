package com.example.amphibians.data

import com.example.amphibians.model.AmphibianItem
import com.example.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<AmphibianItem>
}

class NetworkAmphibiansRepository (
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<AmphibianItem> {
        return amphibiansApiService.getAmphibians()
    }
}