package com.ravishrajput.restapi.data

import com.ravishrajput.restapi.model.AirlinesDetails
import com.ravishrajput.restapi.model.FareDetails
import com.ravishrajput.restapi.model.Flight

interface FlightsRepository {
    suspend fun getFlights(): List<Flight>
    suspend fun getFareDetails(id: String): FareDetails
    suspend fun getAirlineDetails(id: String): AirlinesDetails

    companion object Factory {
        fun create(): FlightsRepository = FlightsRepositoryImpl(DummyDataFactory())
    }
}