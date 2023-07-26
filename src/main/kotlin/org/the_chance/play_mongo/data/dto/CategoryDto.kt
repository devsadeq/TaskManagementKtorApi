package org.the_chance.play_mongo.data.dto

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id

@Serializable
data class CategoryDto(
    @BsonId
    val id: Id<CategoryDto>? = null,
    val name: String,
    val description: String? = null,
    val tasksIds: List<String> = listOf(),
)