package org.the_chance.play_mongo.di

import org.koin.core.annotation.Module
import org.koin.dsl.module
import org.litote.kmongo.KMongo

@Module
class AppModule {

    val mongoClientModule = module {
        single { KMongo.createClient("mongodb+srv://username:password@cluster0.ejfkr.mongodb.net/") }
    }
}