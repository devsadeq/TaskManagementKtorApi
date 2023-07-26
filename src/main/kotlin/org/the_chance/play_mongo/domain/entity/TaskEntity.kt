package org.the_chance.play_mongo.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class TaskEntity(
    val id: String,
    val title: String,
    val description: String? = null,
    val status: TaskStatus = TaskStatus.TODO,
    val ownerId: String,
    val assigneeId: String,
    val tags: List<String> = listOf(),
    val categoryId: String? = null
)