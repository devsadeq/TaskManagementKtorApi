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
    val status: String = "TODO",
    val ownerId: String,
    val assigneeId: String = ownerId,
    val tags: List<String> = listOf(),
    val categoryId: String? = null
)