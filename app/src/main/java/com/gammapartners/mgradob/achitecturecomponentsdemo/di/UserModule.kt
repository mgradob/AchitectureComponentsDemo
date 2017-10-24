package com.gammapartners.mgradob.achitecturecomponentsdemo.di

import android.arch.persistence.room.Room
import android.content.Context
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.database.Database
import com.gammapartners.mgradob.achitecturecomponentsdemo.repositories.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by mgradob on 10/23/17.
 */
@Module
class UserModule(val app: App) {

    @Provides
    fun providesAppContext() = app.applicationContext

    @Provides
    @Singleton
    fun providesDatabase(context: Context) =
            Room.databaseBuilder(context, Database::class.java, "db")
                    .build()

    @Provides
    @Singleton
    fun providesUserRepository(context: Context) = UserRepository(context)
}