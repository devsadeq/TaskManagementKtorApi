package org.the_chance.play_mongo.repository.mapper

import org.the_chance.play_mongo.data.dto.CategoryDto
import org.the_chance.play_mongo.domain.entity.CategoryEntity

fun CategoryDto.toEntity(): CategoryEntity {
    return CategoryEntity(
        id = this.id.toString(),
        name = this.name,
        description = this.description,
        tasksIds = this.tasksIds
    )
}

fun List<CategoryDto>.toEntity(): List<CategoryEntity> {
    return this.map { it.toEntity() }
}

fun CategoryEntity.toDto(): CategoryDto {
    return CategoryDto(
        name = this.name,
        description = this.description,
        tasksIds = this.tasksIds
    )
}

fun List<CategoryEntity>.toDto(): List<CategoryDto> {
    return this.map { it.toDto() }
}