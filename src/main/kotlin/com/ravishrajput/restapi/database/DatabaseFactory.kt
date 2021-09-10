package com.ravishrajput.restapi.database

import com.ravishrajput.restapi.utils.dbQuery
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils

object DatabaseFactory {

    suspend fun init() {
        Database.connect("mysql://ftbzzv0i9fnfsalq:fmhh9wvgm6d12wpq@eporqep6b4b8ql12.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/i4b1j5lsw9bt7mzr", driver = "org.mariadb.jdbc.Driver")
        dbQuery {
            SchemaUtils.create(Users)
        }
    }
}