package org.the_chance.play_mongo.endpoints

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.the_chance.play_mongo.data.dto.TaskDto
import org.the_chance.play_mongo.domain.usecase.*
import org.the_chance.play_mongo.endpoints.utils.shouldNotBeNull
import org.the_chance.play_mongo.endpoints.utils.wrapCall
import org.the_chance.play_mongo.repository.mapper.toEntity

fun Route.taskRoutes() {

    val createTask: CreateTaskUseCase by inject()
    val getTasks: GetTasksUseCase by inject()
    val getTaskById: GetTaskByIdUseCase by inject()
    val updateTask: UpdateTaskUseCase by inject()
    val deleteTask: DeleteTaskUseCase by inject()

    route("/tasks") {

        get {
            wrapCall(call) {
                call.respond(getTasks())
            }
        }

        get("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                call.respond(getTaskById(id))
            }
        }

        post {
            wrapCall(call) {
                val task = call.receive<TaskDto>()
                createTask(task.toEntity())
                call.respondText("Task added correctly", status = HttpStatusCode.Created)
            }
        }

        put("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                val task = call.receive<TaskDto>()
                updateTask(id, task.toEntity())
                call.respondText("Task updated correctly", status = HttpStatusCode.OK)
            }
        }

        delete("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                deleteTask(id)
                call.respondText("Task deleted correctly", status = HttpStatusCode.OK)
            }
        }
    }
}