package com.ravishrajput.restapi.database

import com.ravishrajput.restapi.utils.dbQuery
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

object DatabaseFactory {

    suspend fun init() {
        Database.connect("jdbc:mariadb://localhost:3306/ktor_test_data?user=root&password=ravish", driver = "org.mariadb.jdbc.Driver")
        dbQuery {
            SchemaUtils.create(Users)
        }
    }
}