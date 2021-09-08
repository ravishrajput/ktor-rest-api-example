package com.ravishrajput.restapi

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.database.DatabaseFactory
import com.ravishrajput.restapi.routing.configureRouting
import com.ravishrajput.restapi.utils.Constants.BASIC_AUTH
import com.ravishrajput.restapi.utils.Constants.HOST_NAME
import com.ravishrajput.restapi.utils.Constants.PORT
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.auth.basic
import io.ktor.auth.UserIdPrincipal
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.routing.Routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.coroutines.launch

fun main() {
    embeddedServer(Netty, port = PORT, host = HOST_NAME, module = Application::module).start()
}

fun Application.module() {

    install(Authentication) {
        basic(BASIC_AUTH) {
            validate { credentials ->
                if (credentials.name == "username" && credentials.password == "password") {
                    UserIdPrincipal(credentials.name)
                } else {
                    null
                }
            }
        }
    }

    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    launch {
        DatabaseFactory.init()
    }

    val dao = DaoRepository.create()

    install(Routing) {
        configureRouting(dao)
    }
}