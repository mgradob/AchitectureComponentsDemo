package com.gammapartners.mgradob.achitecturecomponentsdemo.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User

/**
 * Created by mgradob on 10/23/17.
 */
@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun userDao(): UserDao
}