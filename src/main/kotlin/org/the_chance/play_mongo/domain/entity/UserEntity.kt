package org.the_chance.play_mongo.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class UserEntity(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val tasksIds: List<String>
)