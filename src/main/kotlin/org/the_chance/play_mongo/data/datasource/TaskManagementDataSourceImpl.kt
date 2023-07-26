package org.the_chance.play_mongo.data.datasource

import org.bson.types.ObjectId
import org.koin.core.annotation.Single
import org.litote.kmongo.*
import org.the_chance.play_mongo.data.TaskManagementDatabase
import org.the_chance.play_mongo.data.dto.CategoryDto
import org.the_chance.play_mongo.data.dto.TaskDto
import org.the_chance.play_mongo.data.dto.UserDto
import org.the_chance.play_mongo.domain.TaskManagementException
import org.the_chance.play_mongo.repository.TaskManagementDataSource

@Single
class TaskManagementDataSourceImpl(db: TaskManagementDatabase) : TaskManagementDataSource {

    private val userCollection = db.database.getCollection<UserDto>("users")
    private val taskCollection = db.database.getCollection<TaskDto>("tasks")
    private val categoryCollection = db.database.getCollection<CategoryDto>("categories")


    override fun getTasks(filter: String): List<TaskDto> {
        return taskCollection.find(filter).toList()
    }

    override fun getTaskById(id: String): TaskDto {
        return taskCollection.findOneById(id) ?: throw TaskManagementException.NotFound
    }

    override fun createTask(task: TaskDto): Boolean {
        return taskCollection.insertOne(task).wasAcknowledged()
    }

    override fun updateTask(id: String, task: TaskDto): Boolean {
        return taskCollection.updateOneById(id, task).wasAcknowledged()
    }

    override fun deleteTask(id: String): Boolean {
        return taskCollection.deleteOneById(id).wasAcknowledged()
    }

    override fun deleteAllTasks(): Boolean {
        return taskCollection.deleteMany("{}").wasAcknowledged()
    }


    override fun createCategory(category: CategoryDto): Boolean {
        try {
            getCategoryByName(category.name)
            throw TaskManagementException.AlreadyExists
        } catch (e: TaskManagementException.NotFound) {
            return categoryCollection.insertOne(category).wasAcknowledged()
        }
    }

    override fun getCategoryByName(name: String): CategoryDto {
        return categoryCollection.findOne(CategoryDto::name eq name) ?: throw TaskManagementException.NotFound
    }

    override fun getCategories(): List<CategoryDto> {
        return categoryCollection.find().toList()
    }

    override fun getCategoryById(id: String): CategoryDto {
        return categoryCollection.findOneById(ObjectId(id)) ?: throw TaskManagementException.NotFound
    }

    override fun updateCategory(id: String, category: CategoryDto): Boolean {
        try {
            getCategoryById(id)
            return categoryCollection.updateOneById(ObjectId(id), category).wasAcknowledged()
        } catch (e: TaskManagementException.NotFound) {
            throw e
        }
    }

    override fun deleteCategory(id: String): Boolean {
        val result = categoryCollection.deleteOneById(ObjectId(id))
        if (result.deletedCount == 0L) throw TaskManagementException.NotFound
        return result.wasAcknowledged()
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
        return userCollection.findOneById(ObjectId(id)) ?: throw TaskManagementException.NotFound
    }

    override fun updateUser(id: String, user: UserDto): UserDto {
        try {
            getUserById(id)
            return userCollection.updateOneById(ObjectId(id), user).let { user }
        } catch (e: TaskManagementException.NotFound) {
            throw e
        }
    }

    override fun deleteUser(id: String): Boolean {
        return userCollection.deleteOneById(ObjectId(id)).wasAcknowledged()
    }

    override fun deleteAllUsers(): Boolean {
        return userCollection.deleteMany().wasAcknowledged()
    }
}
