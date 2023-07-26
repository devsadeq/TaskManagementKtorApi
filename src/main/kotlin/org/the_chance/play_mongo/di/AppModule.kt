package org.the_chance.play_mongo.di

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import org.bson.UuidRepresentation
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.dsl.module
import org.litote.kmongo.KMongo

@Module
@ComponentScan("org.the_chance.play_mongo")
class AppModule

val mongoClientModule = module {
    single {
        KMongo.createClient(
            MongoClientSettings.builder()
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .applyConnectionString(ConnectionString("mongodb+srv://username:password@cluster0.ejfkr.mongodb.net/"))
                .build()
        )
    }
}