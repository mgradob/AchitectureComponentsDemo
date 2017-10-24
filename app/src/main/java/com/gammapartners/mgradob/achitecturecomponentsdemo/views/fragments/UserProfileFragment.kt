package com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gammapartners.mgradob.achitecturecomponentsdemo.R
import com.gammapartners.mgradob.achitecturecomponentsdemo.models.User
import com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels.UserProfileViewModel
import kotlinx.android.synthetic.main.fragment_user_profile.*

/**
 * A simple [Fragment] subclass.
 */
class UserProfileFragment : LifecycleFragment() {

    companion object {
        val KEY_UID = "uid"
    }

    private var mViewModel : UserProfileViewModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userId = arguments?.getString(KEY_UID) ?: ""

        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        mViewModel?.init(userId)
        mViewModel?.user?.observe(this, Observer<User> { user ->
            nameTV.text = user?.name
            ageTV.text = "${user?.age}"
        })

        nameET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i("", "Changed name value")
            }
        })

        ageET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.i("", "Changed age value")
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_user_profile, container, false)
}
