package org.the_chance.play_mongo.data.dto

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class TaskDto(
    @BsonId
    val id: Id<TaskDto>? = null,
    val title: String,
    val description: String? = null,
    val status: TaskStatus = TaskStatus.TODO,
    val ownerId: Id<UserDto>,
    val assigneeId: Id<UserDto> = ownerId,
    val tags: List<String> = listOf(),
    val category: CategoryDto? = null
)