package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.TaskEntity

@Single
class GetTasksUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(
        byCategory: String? = null,
        byStatus: String? = null,
    ): List<TaskEntity> {
        return repository.getTasks("{${if (byCategory != null) "categoryId: '$byCategory'" else ""}${if (byStatus != null) "status: '$byStatus'" else ""}}")
    }
}