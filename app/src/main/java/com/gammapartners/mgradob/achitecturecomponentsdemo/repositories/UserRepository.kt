package com.gammapartners.mgradob.achitecturecomponentsdemo.repositories

import android.arch.lifecycle.LiveData
import android.content.Context
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.database.Database
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import javax.inject.Inject

/**
 * Created by mgradob on 10/23/17.
 */
class UserRepository(context: Context) {

    @Inject lateinit var mDatabase: Database

    init {
        (context as App).mAppComponent.inject(this)
    }

    fun getUser(userId: String): LiveData<User> = mDatabase.userDao().load(userId)
}