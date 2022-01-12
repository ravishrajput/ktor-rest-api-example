package com.ravishrajput.restapi.model

data class Flight(
    val id: String,
    val from: String,
    val to: String,
    val departure: String,
    val arrival: String,
    val airlinesName: String,
    val airlinesId: String,
    val totalFare: Int,
    val fareDetailsId: String
)

data class AirlinesDetails(
    val id: String,
    val name: String,
    val stops: List<StopsDetails>,
    val seatsAvailable: Int,
    val baggageDetails: BaggageDetails?
)

data class StopsDetails(val id: String, val city: String, val arrival: String, val departure: String)

data class FareDetails(val id: String, val airlinesCharges: Int, val fuelCharges: Int, val airportTaxes: Int)

data class BaggageDetails(val cabin: Boolean, val checkin: Boolean, val chargesPerExtraKg: Int)
