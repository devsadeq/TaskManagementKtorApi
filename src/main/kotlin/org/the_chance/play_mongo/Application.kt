package org.the_chance.play_mongo

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import org.the_chance.play_mongo.di.AppModule
import org.the_chance.play_mongo.di.mongoClientModule
import org.the_chance.play_mongo.plugins.configureMonitoring
import org.the_chance.play_mongo.plugins.configureRouting
import org.the_chance.play_mongo.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    install(Koin) {
        modules(AppModule().module, mongoClientModule)
    }
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
