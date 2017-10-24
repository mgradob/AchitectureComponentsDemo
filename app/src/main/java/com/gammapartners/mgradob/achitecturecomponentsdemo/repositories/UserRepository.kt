package com.gammapartners.mgradob.achitecturecomponentsdemo.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.database.Database
import com.gammapartners.mgradob.achitecturecomponentsdemo.database.UserDao
import com.gammapartners.mgradob.achitecturecomponentsdemo.di.AppComponent
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mgradob on 10/23/17.
 */
class UserRepository {

    @Inject lateinit var mDatabase: Database

    init {
        (App.get() as App).mAppComponent?.inject(this)
    }

    fun getUser(userId: String) : LiveData<User> = mDatabase.userDao().load(userId)
}