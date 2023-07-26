package org.the_chance.play_mongo.domain

import org.the_chance.play_mongo.domain.entity.CategoryEntity
import org.the_chance.play_mongo.domain.entity.TaskEntity
import org.the_chance.play_mongo.domain.entity.UserEntity

interface TaskManagementRepository {

    fun getTasks(): List<TaskEntity>

    fun getTaskById(id: String): TaskEntity

    fun getTaskByStatus(status: String): List<TaskEntity>

    fun getTasksByCategory(categoryId: String): List<TaskEntity>

    fun createTask(task: TaskEntity): Boolean

    fun updateTask(task: TaskEntity): Boolean

    fun deleteTask(id: String): Boolean

    fun deleteAllTasks(): Boolean


    fun createCategory(category: CategoryEntity): Boolean

    fun getCategories(): List<CategoryEntity>

    fun getCategoryById(id: String): CategoryEntity

    fun getCategoryByName(name: String): CategoryEntity

    fun updateCategory(id: String, category: CategoryEntity): Boolean

    fun deleteCategory(id: String): Boolean

    fun deleteAllCategories(): Boolean


    fun createUser(user: UserEntity): UserEntity

    fun getUsers(): List<UserEntity>

    fun getUserById(id: String): UserEntity

    fun updateUser(user: UserEntity): UserEntity

    fun deleteUser(id: String): Boolean

    fun deleteAllUsers(): Boolean
}