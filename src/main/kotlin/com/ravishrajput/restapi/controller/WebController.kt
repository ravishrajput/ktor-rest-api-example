package com.ravishrajput.restapi.controller

import com.ravishrajput.restapi.model.Web
import io.ktor.application.*
import io.ktor.freemarker.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.routeWeb() {

    static("/") {
        resources("files")
    }

    val blogEntries = mutableListOf(
        Web(
            "REST API Example",
            "This is Dummy API call for POCs"
        )
    )

    get("/") {
        call.respond(FreeMarkerContent("index.ftl", mapOf("entries" to blogEntries), ""))
    }

}