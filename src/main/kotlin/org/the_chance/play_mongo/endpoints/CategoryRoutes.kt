package org.the_chance.play_mongo.endpoints

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import org.the_chance.play_mongo.data.dto.CategoryDto
import org.the_chance.play_mongo.domain.usecase.*
import org.the_chance.play_mongo.endpoints.utils.shouldNotBeNull
import org.the_chance.play_mongo.endpoints.utils.wrapCall
import org.the_chance.play_mongo.repository.mapper.toEntity

fun Route.categoryRoutes() {
    val createCategory: CreateCategoryUseCase by inject()
    val getCategories: GetCategoriesUseCase by inject()
    val getCategoryById: GetCategoryByIdUseCase by inject()
    val getCategoryByName: GetCategoryByNameUseCase by inject()
    val updateCategory: UpdateCategoryUseCase by inject()
    val deleteCategory: DeleteCategoryUseCase by inject()
    val deleteAllCategories: DeleteAllCategoriesUseCase by inject()

    route("/categories") {

        post {
            wrapCall(call) {
                val category = call.receive<CategoryDto>()
                createCategory(category.toEntity())
                call.respondText("Category added correctly", status = HttpStatusCode.Created)
            }
        }

        get {
            wrapCall(call) {
                val response = getCategories()
                call.respond(response)
            }
        }

        get("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                val category = getCategoryById(id)
                call.respond(category)
            }
        }

        get("/name/{name}") {
            wrapCall(call) {
                val name = call.parameters.shouldNotBeNull("name")
                val category = getCategoryByName(name)
                call.respond(category)
            }
        }

        put("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                val category = call.receive<CategoryDto>()
                updateCategory(id, category.toEntity())
                call.respondText("Category updated correctly", status = HttpStatusCode.Accepted)
            }
        }

        delete("/{id}") {
            wrapCall(call) {
                val id = call.parameters.shouldNotBeNull("id")
                call.respond(deleteCategory(id))
            }
        }

        delete {
            wrapCall(call) {
                call.respond(deleteAllCategories())
            }
        }
    }
}