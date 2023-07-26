package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.UserEntity

@Single
class UpdateUserUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(id: String, user: UserEntity): UserEntity {
        return repository.updateUser(id, user)
    }
}