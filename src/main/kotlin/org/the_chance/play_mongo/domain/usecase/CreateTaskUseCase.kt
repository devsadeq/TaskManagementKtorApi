package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.TaskEntity

@Single
class CreateTaskUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(task: TaskEntity): Boolean {
        return repository.createTask(task)
    }
}