package com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import com.gammapartners.mgradob.achitecturecomponentsdemo.repositories.UserRepository
import javax.inject.Inject

/**
 * Created by mgradob on 10/23/17.
 */
class UserProfileViewModel : ViewModel() {

    @Inject lateinit var userRepository: UserRepository

    var userId: String = ""
    var user: LiveData<User>? = null

    fun init(userId: String) {
        this.userId = userId

        this.user = userRepository.getUser(userId)
    }
}