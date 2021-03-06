package com.gammapartners.mgradob.achitecturecomponentsdemo

import android.app.Application
import com.gammapartners.mgradob.achitecturecomponentsdemo.di.AppComponent
import com.gammapartners.mgradob.achitecturecomponentsdemo.di.DaggerAppComponent
import com.gammapartners.mgradob.achitecturecomponentsdemo.di.UserModule

/**
 * Created by mgradob on 10/23/17.
 */
class App : Application() {

    companion object {
        lateinit var mAppComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        mAppComponent = DaggerAppComponent.builder()
                .userModule(UserModule(this))
                .build()
    }
}