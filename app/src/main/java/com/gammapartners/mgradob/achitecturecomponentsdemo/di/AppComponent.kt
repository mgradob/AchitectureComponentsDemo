package com.gammapartners.mgradob.achitecturecomponentsdemo.di

import com.gammapartners.mgradob.achitecturecomponentsdemo.repositories.UserRepository
import com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels.UserProfileViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mgradob on 10/23/17.
 */
@Singleton
@Component(modules = arrayOf(UserModule::class))
interface AppComponent {

    fun inject(userRepository: UserRepository)

    fun inject(userProfileViewModel: UserProfileViewModel)
}