package com.ravishrajput.restapi.controller

import com.ravishrajput.restapi.database.DaoRepository
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
            call.respond(user ?: "Record not found!")
        } ?: call.respond("Invalid id!")
    }

    delete("/user/{id}") {
        val id = call.parameters["id"]
        id?.let {
            dao.deleteUser(it.toInt())
            call.respond("User Deleted!")
        } ?: call.respond("Invalid id!")
    }

    post("/user") {
        val user = call.receive<User>()
        dao.createUser(user)
        call.respond("User Added Successfully!")
    }
}