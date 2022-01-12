package com.ravishrajput.restapi

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.database.DatabaseFactory
import com.ravishrajput.restapi.routing.configureRouting
import com.ravishrajput.restapi.utils.Constants.BASIC_AUTH
import freemarker.cache.ClassTemplateLoader
import freemarker.core.HTMLOutputFormat
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.features.*
import io.ktor.freemarker.*
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
                if (credentials.name == "" && credentials.password == "") {
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

    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "files")
        outputFormat = HTMLOutputFormat.INSTANCE
    }
}