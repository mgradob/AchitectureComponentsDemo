package com.gammapartners.mgradob.achitecturecomponentsdemo.di

import com.gammapartners.mgradob.achitecturecomponentsdemo.repositories.UserRepository
import com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels.UserProfileViewModel
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.activities.MainActivity
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments.EditUserProfileFragment
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments.ViewUserProfileFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by mgradob on 10/23/17.
 */
@Singleton
@Component(modules = arrayOf(UserModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(userRepository: UserRepository)

    fun inject(userProfileViewModel: UserProfileViewModel)
}