package com.ravishrajput.restapi.routing

import com.ravishrajput.restapi.controller.routeUser
import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.utils.Constants.API_VERSION
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting(dao: DaoRepository) {

    routing {
        route(API_VERSION) {
            routeUser(dao)
        }
    }
}