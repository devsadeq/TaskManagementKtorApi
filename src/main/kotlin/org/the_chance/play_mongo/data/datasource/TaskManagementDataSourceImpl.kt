package org.the_chance.play_mongo.data.datasource

import org.litote.kmongo.*
import org.the_chance.play_mongo.data.TaskManagementDatabase
import org.the_chance.play_mongo.data.dto.CategoryDto
import org.the_chance.play_mongo.data.dto.TaskDto
import org.the_chance.play_mongo.data.dto.UserDto
import org.the_chance.play_mongo.domain.TaskManagementException
import org.the_chance.play_mongo.repository.TaskManagementDataSource

class TaskManagementDataSourceImpl(db: TaskManagementDatabase) : TaskManagementDataSource {

    private val userCollection = db.database.getCollection<UserDto>("users")
    private val taskCollection = db.database.getCollection<TaskDto>("tasks")
    private val categoryCollection = db.database.getCollection<CategoryDto>("categories")

    override fun getTasks(): List<TaskDto> {
        return taskCollection.find().toList()
    }

    override fun getTaskById(id: String): TaskDto {
        return taskCollection.findOneById(id) ?: throw TaskManagementException.NotFound
    }

    override fun getTaskByStatus(status: String): List<TaskDto> {
        return taskCollection.find(TaskDto::status eq status).toList()
    }

    override fun getTasksByCategory(categoryId: String): List<TaskDto> {
        return taskCollection.find(TaskDto::categoryId eq categoryId).toList()
    }

    override fun createTask(task: TaskDto): Boolean {
        return taskCollection.insertOne(task).wasAcknowledged()
    }

    override fun updateTask(task: TaskDto): Boolean {
        return taskCollection.updateOneById(task.id!!, task).wasAcknowledged()
    }

    override fun deleteTask(id: String): Boolean {
        return taskCollection.deleteOneById(id).wasAcknowledged()
    }

    override fun deleteAllTasks(): Boolean {
        return taskCollection.deleteMany("{}").wasAcknowledged()
    }

    override fun createCategory(category: CategoryDto): Boolean {
        return categoryCollection.insertOne(category).wasAcknowledged()
    }

    override fun getCategories(): List<CategoryDto> {
        return categoryCollection.find().toList()
    }

    override fun getCategoryById(id: String): CategoryDto {
        return categoryCollection.findOneById(id) ?: throw TaskManagementException.NotFound
    }

    override fun updateCategory(category: CategoryDto): Boolean {
        return categoryCollection.updateOneById(category.id!!, category).wasAcknowledged()
    }

    override fun deleteCategory(id: String): Boolean {
        return categoryCollection.deleteOneById(id).wasAcknowledged()
    }

    override fun deleteAllCategories(): Boolean {
        return categoryCollection.deleteMany().wasAcknowledged()
    }

    override fun createUser(user: UserDto): UserDto {
        return userCollection.insertOne(user).let { user }
    }

    override fun getUsers(): List<UserDto> {
        return userCollection.find().toList()
    }

    override fun getUserById(id: String): UserDto {
        return userCollection.findOneById(id) ?: throw TaskManagementException.NotFound
    }

    override fun updateUser(user: UserDto): UserDto {
        return userCollection.updateOneById(user.id!!, user).let { user }
    }

    override fun deleteUser(id: String): Boolean {
        return userCollection.deleteOneById(id).wasAcknowledged()
    }

    override fun deleteAllUsers(): Boolean {
        return userCollection.deleteMany().wasAcknowledged()
    }
}
