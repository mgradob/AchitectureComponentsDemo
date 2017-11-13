package com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import com.gammapartners.mgradob.achitecturecomponentsdemo.repositories.UserRepository
import io.reactivex.disposables.Disposables
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by mgradob on 10/23/17.
 */
class UserProfileViewModel : ViewModel() {

    @Inject lateinit var mUserRepository: UserRepository

    var userId = 0
    var user: LiveData<User>? = null

    var mDisposable = Disposables.empty()

    fun init(userId: String) {
        App.mAppComponent.inject(this)

        this.userId = userId.toInt()

        this.user = mUserRepository.getUser(userId)
    }

    fun saveName(name: String) {
        mDisposable.dispose()
        mDisposable = mUserRepository.saveUser(User(userId, name, this.user?.value?.age ?: 0))
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun saveAge(age: Int) {
        mDisposable.dispose()
        mDisposable = mUserRepository.saveUser(User(userId, this.user?.value?.name ?: "", age))
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}