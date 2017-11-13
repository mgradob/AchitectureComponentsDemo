package com.gammapartners.mgradob.achitecturecomponentsdemo.repositories

import android.arch.lifecycle.LiveData
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.database.Database
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by mgradob on 10/23/17.
 */
class UserRepository {

    @Inject lateinit var mDatabase: Database

    init {
        App.mAppComponent.inject(this)
    }

    fun getUser(userId: String): LiveData<User> = mDatabase.userDao().load(userId)

    fun saveUser(user: User) = Observable.create<Unit> {
        mDatabase.userDao().save(user)

        it.onNext(Unit)
        it.onComplete()
    }
}