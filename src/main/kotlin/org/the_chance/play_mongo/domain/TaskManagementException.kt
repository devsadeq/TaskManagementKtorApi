package org.the_chance.play_mongo.domain

sealed class TaskManagementException : Exception() {
    object BadRequest : TaskManagementException()

    object NotFound : TaskManagementException()

    object AlreadyExists : TaskManagementException()

}