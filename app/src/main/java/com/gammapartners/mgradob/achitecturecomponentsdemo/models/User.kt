package com.gammapartners.mgradob.achitecturecomponentsdemo.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by mgradob on 10/23/17.
 */
@Entity
data class User(
        @PrimaryKey
        var id: Int,
        var name: String,
        var age: Int
)