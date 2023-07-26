package org.the_chance.play_mongo.domain.entity

data class CategoryEntity(
    val id: String,
    val name: String,
    val description: String? = null,
    val tasksIds: List<String> = listOf(),
)