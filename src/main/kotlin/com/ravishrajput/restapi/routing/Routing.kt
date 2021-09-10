package com.ravishrajput.restapi.routing

import com.ravishrajput.restapi.controller.routeUser
import com.ravishrajput.restapi.controller.routeWeb
import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.utils.Constants.API_VERSION
import com.ravishrajput.restapi.utils.Constants.BASIC_AUTH
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.content.*
import io.ktor.routing.*

fun Application.configureRouting(dao: DaoRepository) {

    routing {
        authenticate(BASIC_AUTH) {
            route(API_VERSION) {
                routeUser(dao)
            }
        }
        routeWeb()
    }
}