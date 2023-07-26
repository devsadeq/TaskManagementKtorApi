package org.the_chance.play_mongo.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.the_chance.play_mongo.endpoints.categoryRoutes
import org.the_chance.play_mongo.endpoints.testRoutes

fun Application.configureRouting(
) {
    routing {
        testRoutes()
        categoryRoutes()
    }
}
