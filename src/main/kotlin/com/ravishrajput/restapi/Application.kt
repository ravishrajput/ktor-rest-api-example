package com.ravishrajput.restapi

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.database.DatabaseFactory
import com.ravishrajput.restapi.routing.configureRouting
import com.ravishrajput.restapi.utils.Constants.BASIC_AUTH
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import kotlinx.coroutines.launch

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {

    install(CORS) {
        anyHost()
    }

    install(Authentication) {
        basic(BASIC_AUTH) {
            validate { credentials ->
                if (credentials.name == "dummyRestApi" && credentials.password == "csb2j9Ak6XjdEP5YIe=") {
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