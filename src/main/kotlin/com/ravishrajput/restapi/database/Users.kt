package com.ravishrajput.restapi.database

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Users : IntIdTable() {
    val name = varchar("name", 50)
    val username = varchar("username", 50)
    val email = varchar("email", 50)
    val imageUrl = varchar("imageUrl", 100)
}

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(Users)

    var name by Users.name
    var username by Users.username
    var email by Users.email
    var imageUrl by Users.imageUrl
}