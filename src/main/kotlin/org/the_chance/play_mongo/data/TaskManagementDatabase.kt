package org.the_chance.play_mongo.data

import com.mongodb.client.MongoClient
import org.koin.core.annotation.Single

@Single
class TaskManagementDatabase(client: MongoClient) {
    val database = client.getDatabase("task_management")
}