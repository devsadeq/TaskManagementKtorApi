package org.the_chance.play_mongo.domain.usecase

import org.koin.core.annotation.Single
import org.the_chance.play_mongo.domain.TaskManagementRepository
import org.the_chance.play_mongo.domain.entity.UserEntity

@Single
class CreateUserUseCase(private val repository: TaskManagementRepository) {

    operator fun invoke(user: UserEntity): UserEntity {
        return repository.createUser(user)
    }
}