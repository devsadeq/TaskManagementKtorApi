package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.CategoryEntity

@Single
class GetCategoriesUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(): List<CategoryEntity> {
        return repository.getCategories()
    }
}