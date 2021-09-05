package com.ravishrajput.restapi.controller

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.model.Response
import com.ravishrajput.restapi.model.User
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.routeUser(dao: DaoRepository) {

    get("/user") {
        val userList = mapOf("users" to dao.getAllUsers())
        call.respond(userList)
    }

    get("/user/{id}") {
        val id = call.parameters["id"]
        id?.let {
            val user = dao.getUser(it.toInt())
            call.respond(user ?: Response(404, "Record not found!"))
        } ?: call.respond(Response(400, "Invalid id!"))
    }

    delete("/user/{id}") {
        val id = call.parameters["id"]
        id?.let {
            dao.deleteUser(it.toInt())
            call.respond(Response(200, "Record deleted!"))
        } ?: call.respond(Response(400, "Invalid id!"))
    }

    post("/user") {
        val user = call.receiveParameters().run {
            User(
                id = null,
                this["name"].toString(),
                this["username"].toString(),
                this["email"].toString(),
                this["imageUrl"].toString()
            )
        }
        dao.createUser(user)
        call.respond(Response(200, "User Added Successfully!"))
    }
}