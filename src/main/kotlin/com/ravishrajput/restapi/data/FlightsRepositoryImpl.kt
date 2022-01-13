package com.ravishrajput.restapi.data

import com.ravishrajput.restapi.model.Airline
import com.ravishrajput.restapi.model.AirlinesDetails
import com.ravishrajput.restapi.model.FareDetails
import com.ravishrajput.restapi.model.Flight

class FlightsRepositoryImpl(private val dummyData: DummyDataFactory) : FlightsRepository {

    override suspend fun getFlights(): List<Flight> {
        return dummyData.getAllFlights()
    }

    override suspend fun getFareDetails(id: String): FareDetails {
        return FareDetails("", 0, 0, 0)
    }

    override suspend fun getAirlineDetails(id: String): AirlinesDetails {
        return AirlinesDetails("", Airline("", ""), emptyList(), 0, null)
    }
}