package org.the_chance.play_mongo.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import org.the_chance.play_mongo.endpoints.categoryRoutes
import org.the_chance.play_mongo.endpoints.taskRoutes
import org.the_chance.play_mongo.endpoints.testRoutes
import org.the_chance.play_mongo.endpoints.userRoutes

fun Application.configureRouting(
) {
    routing {
        testRoutes()
        userRoutes()
        taskRoutes()
        categoryRoutes()
    }
}
