package com.gammapartners.mgradob.achitecturecomponentsdemo.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gammapartners.mgradob.achitecturecomponentsdemo.App
import com.gammapartners.mgradob.achitecturecomponentsdemo.App.Companion
import com.gammapartners.mgradob.achitecturecomponentsdemo.R
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments.EditUserProfileFragment
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments.ViewUserProfileFragment
import kotlinx.android.synthetic.main.activity_main.mainContainerCL
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.mAppComponent.inject(this)

        supportFragmentManager.beginTransaction()
                .add(mainContainerCL.id, ViewUserProfileFragment())
                .add(mainContainerCL.id, EditUserProfileFragment())
                .commit()
    }
}
