package com.ravishrajput.restapi.controller

import com.ravishrajput.restapi.data.FlightsRepository
import com.ravishrajput.restapi.model.Response
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.routeFlights(repo: FlightsRepository) {

    get("/flight/getAllFlights") {
        //val userList = mapOf("users" to dao.getAllUsers())
        call.respond(repo.getFlights())
    }

    get("/flight/fareDetails/{id}") {
        val id = call.parameters["id"]
        id?.let {
            val fareDetails = repo.getFareDetails(it)
            call.respond(fareDetails ?: Response(404, "Record not found!"))
        } ?: call.respond(Response(400, "Invalid id!"))
    }
}