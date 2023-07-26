package org.the_chance.play_mongo.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
    val id: String,
    val name: String,
    val description: String? = null,
    val tasksIds: List<String> = listOf(),
)