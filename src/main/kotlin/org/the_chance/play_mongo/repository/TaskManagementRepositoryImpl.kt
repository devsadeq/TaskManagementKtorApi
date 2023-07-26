package org.the_chance.play_mongo.repository

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.CategoryEntity
import org.the_chance.play_mongo.domain.entity.TaskEntity
import org.the_chance.play_mongo.domain.entity.UserEntity
import org.the_chance.play_mongo.repository.mapper.toDto
import org.the_chance.play_mongo.repository.mapper.toEntity

@Single
class TaskManagementRepositoryImpl(
    private val taskManagementDataSource: TaskManagementDataSource
) : TaskManagementRepository {

    override fun getTasks(): List<TaskEntity> {
        return taskManagementDataSource.getTasks().toEntity()
    }

    override fun getTaskById(id: String): TaskEntity {
        return taskManagementDataSource.getTaskById(id).toEntity()
    }

    override fun getTaskByStatus(status: String): List<TaskEntity> {
        return taskManagementDataSource.getTaskByStatus(status).toEntity()
    }

    override fun getTasksByCategory(categoryId: String): List<TaskEntity> {
        return taskManagementDataSource.getTasksByCategory(categoryId).toEntity()
    }

    override fun createTask(task: TaskEntity): Boolean {
        return taskManagementDataSource.createTask(task.toDto())
    }

    override fun updateTask(task: TaskEntity): Boolean {
        return taskManagementDataSource.updateTask(task.toDto())
    }

    override fun deleteTask(id: String): Boolean {
        return taskManagementDataSource.deleteTask(id)
    }

    override fun deleteAllTasks(): Boolean {
        return taskManagementDataSource.deleteAllTasks()
    }

    override fun createCategory(category: CategoryEntity): Boolean {
        return taskManagementDataSource.createCategory(category.toDto())
    }

    override fun getCategories(): List<CategoryEntity> {
        return taskManagementDataSource.getCategories().toEntity()
    }

    override fun getCategoryById(id: String): CategoryEntity {
        return taskManagementDataSource.getCategoryById(id).toEntity()
    }

    override fun getCategoryByName(name: String): CategoryEntity {
        return taskManagementDataSource.getCategoryByName(name).toEntity()
    }

    override fun updateCategory(id: String, category: CategoryEntity): Boolean {
        return taskManagementDataSource.updateCategory(id, category.toDto())
    }

    override fun deleteCategory(id: String): Boolean {
        return taskManagementDataSource.deleteCategory(id)
    }

    override fun deleteAllCategories(): Boolean {
        return taskManagementDataSource.deleteAllCategories()
    }

    override fun createUser(user: UserEntity): UserEntity {
        return taskManagementDataSource.createUser(user.toDto()).toEntity()
    }

    override fun getUsers(): List<UserEntity> {
        return taskManagementDataSource.getUsers().toEntity()
    }

    override fun getUserById(id: String): UserEntity {
        return taskManagementDataSource.getUserById(id).toEntity()
    }

    override fun updateUser(user: UserEntity): UserEntity {
        return taskManagementDataSource.updateUser(user.toDto()).toEntity()
    }

    override fun deleteUser(id: String): Boolean {
        return taskManagementDataSource.deleteUser(id)
    }

    override fun deleteAllUsers(): Boolean {
        return taskManagementDataSource.deleteAllUsers()
    }
}