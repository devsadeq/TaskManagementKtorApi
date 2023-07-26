package org.the_chance.play_mongo.data.dto

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class UserDto(
    @BsonId
    val id: Id<UserDto>? = null,
    val name: String,
    val email: String,
    val password: String,
    val tasksIds: List<String>
)