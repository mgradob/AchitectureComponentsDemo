package com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gammapartners.mgradob.achitecturecomponentsdemo.R
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels.UserProfileViewModel
import kotlinx.android.synthetic.main.fragment_view_user_profile.ageTV
import kotlinx.android.synthetic.main.fragment_view_user_profile.nameTV

/**
 * Created by mgradob on 10/31/17.
 */
class ViewUserProfileFragment : Fragment() {

    private var mViewModel: UserProfileViewModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userId = arguments?.getString(EditUserProfileFragment.KEY_UID) ?: "0"

        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        mViewModel?.init(userId)
        mViewModel?.user?.observe(this, Observer<User> { user ->
            Log.i("MVVM", "Changed observable value")

            nameTV.text = user?.name
            ageTV.text = "${user?.age}"
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_view_user_profile, container, false)
}