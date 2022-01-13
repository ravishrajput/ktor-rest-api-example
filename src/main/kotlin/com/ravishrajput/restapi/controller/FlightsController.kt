package com.ravishrajput.restapi.controller

import com.ravishrajput.restapi.data.FlightsRepository
import com.ravishrajput.restapi.model.Response
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.util.*

fun Route.routeFlights(repo: FlightsRepository) {

    get("/flight/getAllFlights") {
        val from = call.request.queryParameters["from"]
        val to = call.request.queryParameters["to"]
        val month = call.request.queryParameters["month"]
        val date = call.request.queryParameters["date"]
        val year = Calendar.getInstance().get(Calendar.YEAR)
        val departDate = "$year-$month-$date"

        if (!from.isNullOrEmpty() && !to.isNullOrEmpty()) {
            val response = repo.getFlights().filter {
                it.from == from && it.to == to && it.departure.startsWith(departDate)
            }
            call.respond(response)
        } else {
            call.respond(repo.getFlights())
        }
    }

    get("/flight/fareDetails/{id}") {
        val id = call.parameters["id"]
        id?.let {
            val fareDetails = repo.getFareDetails(it)
            call.respond(fareDetails ?: Response(404, "Record not found!"))
        } ?: call.respond(Response(400, "Invalid id!"))
    }

    get("/flight/airlines/{id}") {
        val id = call.parameters["id"]
        id?.let {
            val fareDetails = repo.getAirlineDetails(it)
            call.respond(fareDetails ?: Response(404, "Record not found!"))
        } ?: call.respond(Response(400, "Invalid id!"))
    }

    get("/flight/airlines") {
        call.respond(repo.getAllAirlines())
    }

    get("/flight/cities") {
        call.respond(repo.getAllCities())
    }
}