package com.ravishrajput.restapi

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.database.DatabaseFactory
import com.ravishrajput.restapi.routing.configureRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.gson.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.launch

fun main() {
    embeddedServer(Netty, port = 8181, host = "0.0.0.0", module = Application::module).start()
}

fun Application.module() {
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