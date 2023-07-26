package org.the_chance.play_mongo.repository.mapper

import org.the_chance.play_mongo.data.dto.UserDto
import org.the_chance.play_mongo.domain.entity.UserEntity

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        id = this.id.toString(),
        name = this.name,
        email = this.email,
        password = this.password,
        tasksIds = this.tasksIds
    )
}

fun List<UserDto>.toEntity(): List<UserEntity> {
    return this.map { it.toEntity() }
}

fun UserEntity.toDto(): UserDto {
    return UserDto(
        name = this.name,
        email = this.email,
        password = this.password,
        tasksIds = this.tasksIds
    )
}

fun List<UserEntity>.toDto(): List<UserDto> {
    return this.map { it.toDto() }
}