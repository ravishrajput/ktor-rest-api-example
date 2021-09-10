package com.ravishrajput.restapi.database

import com.ravishrajput.restapi.utils.dbQuery
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

object DatabaseFactory {

    suspend fun init() {
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")

        dbQuery {
            SchemaUtils.create(Users)
        }
    }
}