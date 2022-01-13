package com.ravishrajput.restapi.data

import com.ravishrajput.restapi.model.Airline
import com.ravishrajput.restapi.model.AirlinesDetails
import com.ravishrajput.restapi.model.City
import com.ravishrajput.restapi.model.FareDetails
import com.ravishrajput.restapi.model.Flight

class FlightsRepositoryImpl(private val dummyData: DummyDataFactory) : FlightsRepository {

    override suspend fun getFlights(): List<Flight> = dummyData.getAllFlights()

    override suspend fun getFareDetails(id: String): FareDetails? = dummyData.fareDetailsList.find { it.id == id }

    override suspend fun getAirlineDetails(id: String): AirlinesDetails? =
        dummyData.airlinesDetailsList.find { it.id == id }

    override suspend fun getAllCities(): List<City> = dummyData.getCities

    override suspend fun getAllAirlines(): List<Airline> = dummyData.getAirlines
}