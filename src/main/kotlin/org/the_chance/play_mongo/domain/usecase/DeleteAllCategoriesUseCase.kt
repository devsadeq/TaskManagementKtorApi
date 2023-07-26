package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository

@Single
class DeleteAllCategoriesUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(): Boolean {
        return repository.deleteAllCategories()
    }
}