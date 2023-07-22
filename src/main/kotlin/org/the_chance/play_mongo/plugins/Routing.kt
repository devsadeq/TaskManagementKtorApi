package org.the_chance.play_mongo.plugins

import org.the_chance.play_mongo.endpoints.testRoutes
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting(
) {
    routing {
        testRoutes()
    }
}
