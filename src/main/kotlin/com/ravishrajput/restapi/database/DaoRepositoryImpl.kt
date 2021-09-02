package com.ravishrajput.restapi.database

import com.ravishrajput.restapi.model.User
import com.ravishrajput.restapi.utils.dbQuery
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class DaoRepositoryImpl : DaoRepository {

    override suspend fun createUser(user: User) = dbQuery {
        UserDao.new {
            name = user.name
            username = user.username
            email = user.email
            imageUrl = user.imageUrl
        }
        Unit
    }

    override suspend fun updateUser(user: User) = dbQuery {
        Users.update({ Users.id eq user.id }) {
            it[name] = user.name
            it[username] = username
            it[email] = user.email
            it[imageUrl] = user.imageUrl
        }
        Unit
    }

    override suspend fun deleteUser(id: Int) = dbQuery {
        Users.deleteWhere { Users.id eq id }
        Unit
    }

    override suspend fun getUser(id: Int): User? = dbQuery {
        Users.select { Users.id eq id }.map {
            User(it[Users.id].value, it[Users.name], it[Users.username], it[Users.email], it[Users.imageUrl])
        }.singleOrNull()
    }

    override suspend fun getAllUsers(): List<User> = dbQuery {
        UserDao.all().map {
            User(it.id.value, it.name, it.username, it.email, it.imageUrl)
        }
    }

    override fun close() {}

}