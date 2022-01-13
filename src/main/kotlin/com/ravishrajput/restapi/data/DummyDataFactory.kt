package com.ravishrajput.restapi.data

import com.ravishrajput.restapi.model.Airline
import com.ravishrajput.restapi.model.AirlinesDetails
import com.ravishrajput.restapi.model.BaggageDetails
import com.ravishrajput.restapi.model.City
import com.ravishrajput.restapi.model.FareDetails
import com.ravishrajput.restapi.model.Flight
import com.ravishrajput.restapi.model.StopsDetails
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import kotlin.streams.asSequence


class DummyDataFactory {

    private val dfDateTime = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
    private val flights: MutableList<Flight> = mutableListOf()
    val airlinesDetailsList = mutableListOf<AirlinesDetails>()
    val fareDetailsList = listOf(
        FareDetails(randomId(), 1340, 300, 1194),
        FareDetails(randomId(), 940, 120, 1304),
        FareDetails(randomId(), 1140, 1300, 904),
        FareDetails(randomId(), 5340, 1400, 400),
        FareDetails(randomId(), 3840, 1110, 450),
        FareDetails(randomId(), 4940, 1100, 564),
        FareDetails(randomId(), 2440, 1600, 394),
        FareDetails(randomId(), 4340, 1203, 344),
        FareDetails(randomId(), 2240, 1390, 154),
        FareDetails(randomId(), 3380, 1459, 1784),
        FareDetails(randomId(), 5900, 1294, 1090)
    )
    val getCities = listOf(
        City("del", "Delhi"),
        City("bom", "Mumbai"),
        City("blr", "Bangalore"),
        City("cal", "Kolkata"),
        City("maa", "Chennai"),
        City("pun", "Pune"),
        City("noi", "Noida"),
        City("jai", "Jaipur"),
        City("hyd", "Hyderabad"),
        City("goi", "Goa")
    )

    val getAirlines = listOf(
        Airline("ABA", "AB Airlines"),
        Airline("HEF", "Hello Fly"),
        Airline("MEE", "Meego"),
        Airline("LEG", "Let's Go"),
        Airline("HIS", "High Sky"),
        Airline("FLH", "Fly High")
    )

    init {
        createDummyData()
    }

    private fun createDummyData(): List<Flight> {
        for (i in 1..2) {
            flights.add(generateFlightData(i))
        }
        return flights
    }

    fun getAllFlights(): List<Flight> = flights

    private fun generateFlightData(i: Int): Flight {
        val from = getCities.random().id
        var to = getCities.random().id
        while (from == to) {
            to = getCities.random().id
        }
        val airlines = getRandomAirlines(to, from)
        val fareDetails = fareDetailsList.random()
        val totalFare = fareDetails.airlinesCharges + fareDetails.fuelCharges + fareDetails.airlinesCharges
        val gc = getRandomDateAndTime()
        val departure = dfDateTime.format(gc.time)
        gc.add(Calendar.MINUTE, getRandomMinutesToAdd())
        val arrival = dfDateTime.format(gc.time)
        return Flight(
            generateId(i),
            from,
            to,
            departure,
            arrival,
            airlines.airline.name,
            airlines.id,
            totalFare,
            fareDetails.id
        )
    }

    private fun generateId(i: Int): String {
        val a = 10000000 + i
        return "FLY$a"
    }

    private fun getRandomAirlines(to: String, from: String): AirlinesDetails {
        val airline = getAirlines.random()
        val id = "${airline.id}$to$from"
        airlinesDetailsList.add(
            AirlinesDetails(
                id,
                airline,
                getRandomStopDetails(to, from),
                getRandomSeatsAvailable(),
                getBaggageDetailsRandom()
            )
        )
        return airlinesDetailsList.random()
    }

    private fun getRandomStopDetails(to: String, from: String): List<StopsDetails> {
        val list = mutableListOf<StopsDetails>()
        var stop = getCities.random()
        while (stop.id == to && stop.id == from) {
            stop = getCities.random()
        }
        list.add(StopsDetails(stop, "11:20 21/01/2022", "13:10 21/01/2022"))
        return list
    }

    private fun getBaggageDetailsRandom() = listOf(
        BaggageDetails(true, true, 100),
        BaggageDetails(true, false, 150),
        BaggageDetails(true, true, 200),
        BaggageDetails(true, false, 210),
        BaggageDetails(true, true, 180),
        BaggageDetails(true, false, 140),
        BaggageDetails(true, true, 170),
        BaggageDetails(true, true, 120),
        BaggageDetails(true, false, 90),
        BaggageDetails(true, true, 99)
    ).random()

    private fun getRandomSeatsAvailable() = listOf(
        28,
        86,
        46,
        78,
        98,
        200,
        194,
        219,
        98,
        198,
        156,
        189,
        199,
        23
    ).random()

    private fun getRandomMinutesToAdd() = listOf(
        50,
        60,
        100,
        120,
        130,
        140,
        150,
        200,
        220,
        250,
        230,
        190
    ).random()

    private fun randomId(): String {
        val source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321"
        return Random().ints(7, 0, source.length)
            .asSequence()
            .map(source::get)
            .joinToString("")
    }

    private fun getRandomDateAndTime(): GregorianCalendar {
        val year = 2022
        val month: Int = getRandomBetween(0, 11)
        val date: Int = getRandomBetween(1, 30)
        val hour: Int = getRandomBetween(0, 23)
        val minute: Int = getRandomBetween(0, 59)
        return GregorianCalendar(year, month, date, hour, minute)
    }

    private fun getRandomBetween(start: Int, end: Int): Int {
        return start + (Math.random() * (end - start)).roundToInt()
    }
}