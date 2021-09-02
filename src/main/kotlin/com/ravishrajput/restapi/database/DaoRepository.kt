package com.ravishrajput.restapi.database

import com.ravishrajput.restapi.model.User
import io.ktor.utils.io.core.*

interface DaoRepository : Closeable {
    suspend fun createUser(user: User)
    suspend fun updateUser(user: User)
    suspend fun deleteUser(id: Int)
    suspend fun getUser(id: Int): User?
    suspend fun getAllUsers(): List<User>

    companion object Factory {
        fun create(): DaoRepository = DaoRepositoryImpl()
    }
}