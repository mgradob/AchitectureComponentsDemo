package com.gammapartners.mgradob.achitecturecomponentsdemo.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gammapartners.mgradob.achitecturecomponentsdemo.R
import com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments.UserProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .replace(mainContainerCL.id, UserProfileFragment())
                .commit()
    }
}
