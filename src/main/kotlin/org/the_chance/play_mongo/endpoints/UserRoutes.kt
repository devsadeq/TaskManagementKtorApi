package org.the_chance.play_mongo.endpoints

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.the_chance.play_mongo.data.dto.UserDto
import org.the_chance.play_mongo.domain.usecase.*
import org.the_chance.play_mongo.endpoints.utils.shouldNotBeNull
import org.the_chance.play_mongo.endpoints.utils.wrapCall
import org.the_chance.play_mongo.repository.mapper.toEntity

fun Route.userRoutes() {
    val createUser: CreateUserUseCase by inject()
    val getUsers: GetUsersUseCase by inject()
    val getUserById: GetUserByIdUseCase by inject()
    val updateUser: UpdateUserUseCase by inject()
    val deleteUser: DeleteUserUseCase by inject()

    route("/users") {

        get {
            wrapCall(call) {
                call.respond(getUsers())
            }
        }

        get("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                call.respond(getUserById(id))
            }
        }

        post {
            wrapCall(call) {
                val user = call.receive<UserDto>()
                createUser(user.toEntity())
                call.respondText("User added correctly", status = HttpStatusCode.Created)
            }
        }

        put("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                val user = call.receive<UserDto>()
                call.respond(updateUser(id, user.toEntity()))
            }
        }

        delete("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                call.respond(deleteUser(id))
            }
        }
    }
}