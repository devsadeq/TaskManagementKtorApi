package org.the_chance.play_mongo.domain.entity

data class UserEntity(
    val id: String,
    val name: String,
    val email: String,
    val password: String,
    val tasksIds: List<String>
)