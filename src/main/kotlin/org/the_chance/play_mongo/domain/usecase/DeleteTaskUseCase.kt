package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository

@Single
class DeleteTaskUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(id: String): Boolean {
        return repository.deleteTask(id)
    }
}