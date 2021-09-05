package com.ravishrajput

import com.ravishrajput.restapi.database.DaoRepository
import com.ravishrajput.restapi.routing.configureRouting
import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting(DaoRepository.create()) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}