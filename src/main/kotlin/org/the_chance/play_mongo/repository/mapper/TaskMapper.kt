package org.the_chance.play_mongo.repository.mapper

import org.the_chance.play_mongo.data.dto.TaskDto
import org.the_chance.play_mongo.domain.entity.TaskEntity
import org.the_chance.play_mongo.domain.entity.TaskStatus

fun TaskDto.toEntity(): TaskEntity {
    return TaskEntity(
        id = this.id.toString(),
        title = this.title,
        description = this.description,
        status = this.status.toTaskStatus(),
        ownerId = this.ownerId,
        assigneeId = this.assigneeId,
        tags = this.tags,
        categoryId = this.categoryId
    )
}

fun List<TaskDto>.toEntity(): List<TaskEntity> {
    return this.map { it.toEntity() }
}

fun TaskEntity.toDto(): TaskDto {
    return TaskDto(
        title = this.title,
        description = this.description,
        status = this.status.toString(),
        ownerId = this.ownerId,
        assigneeId = this.assigneeId,
        tags = this.tags,
        categoryId = this.categoryId
    )
}

fun List<TaskEntity>.toDto(): List<TaskDto> {
    return this.map { it.toDto() }
}

private fun String.toTaskStatus(): TaskStatus {
    return when (this) {
        "TODO" -> TaskStatus.TODO
        "IN_PROGRESS" -> TaskStatus.IN_PROGRESS
        "DONE" -> TaskStatus.DONE
        else -> throw IllegalArgumentException("Invalid status")
    }
}