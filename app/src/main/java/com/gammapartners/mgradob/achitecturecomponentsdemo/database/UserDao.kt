package com.gammapartners.mgradob.achitecturecomponentsdemo.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User

/**
 * Created by mgradob on 10/23/17.
 */
@Dao
interface UserDao {

    @Insert(onConflict = REPLACE)
    fun save(user: User)

    @Query("SELECT * FROM user WHERE user.id = :userId")
    fun load(userId: String): LiveData<User>

    @Update(onConflict = REPLACE)
    fun update(user: User)

    @Delete
    fun delete(user: User)
}