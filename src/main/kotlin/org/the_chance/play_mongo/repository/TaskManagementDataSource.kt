package org.the_chance.play_mongo.repository

import org.the_chance.play_mongo.data.dto.CategoryDto
import org.the_chance.play_mongo.data.dto.TaskDto
import org.the_chance.play_mongo.data.dto.UserDto

interface TaskManagementDataSource {

    fun getTasks(): List<TaskDto>

    fun getTaskById(id: String): TaskDto

    fun getTaskByStatus(status: String): List<TaskDto>

    fun getTasksByCategory(categoryId: String): List<TaskDto>

    fun createTask(task: TaskDto): Boolean

    fun updateTask(task: TaskDto): Boolean

    fun deleteTask(id: String): Boolean

    fun deleteAllTasks(): Boolean


    fun createCategory(category: CategoryDto): Boolean

    fun getCategories(): List<CategoryDto>

    fun getCategoryById(id: String): CategoryDto

    fun getCategoryByName(name: String): CategoryDto

    fun updateCategory(id: String, category: CategoryDto): Boolean

    fun deleteCategory(id: String): Boolean

    fun deleteAllCategories(): Boolean


    fun createUser(user: UserDto): UserDto

    fun getUsers(): List<UserDto>

    fun getUserById(id: String): UserDto

    fun updateUser(user: UserDto): UserDto

    fun deleteUser(id: String): Boolean

    fun deleteAllUsers(): Boolean

}