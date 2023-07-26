package org.the_chance.play_mongo.endpoints.utils

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.the_chance.play_mongo.domain.TaskManagementException

suspend fun wrapCall(call: ApplicationCall, block: suspend () -> Unit) {
    try {
        block()
    } catch (e: TaskManagementException.NotFound) {
        call.respondText("Resource not found", status = HttpStatusCode.NotFound)
    } catch (e: TaskManagementException.AlreadyExists) {
        call.respondText("Resource already exists", status = HttpStatusCode.Conflict)
    } catch (e: TaskManagementException.BadRequest) {
        call.respondText("Bad request", status = HttpStatusCode.BadRequest)
    } catch (e: Exception) {
        call.respondText("Internal server error", status = HttpStatusCode.InternalServerError)
    }
}

fun Parameters.shouldNotBeNull(key: String): String {
    return this[key] ?: throw TaskManagementException.BadRequest
}