package com.gammapartners.mgradob.achitecturecomponentsdemo.views.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gammapartners.mgradob.achitecturecomponentsdemo.R
import com.gammapartners.mgradob.achitecturecomponentsdemo.viewmodels.UserProfileViewModel
import kotlinx.android.synthetic.main.fragment_edit_user_profile.ageET
import kotlinx.android.synthetic.main.fragment_edit_user_profile.nameET

/**
 * A simple [Fragment] subclass.
 */
class EditUserProfileFragment : Fragment() {

    companion object {
        val KEY_UID = "uid"
    }

    private var mViewModel: UserProfileViewModel? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val userId = arguments?.getString(KEY_UID) ?: "0"

        mViewModel = ViewModelProviders.of(this).get(UserProfileViewModel::class.java)
        mViewModel?.init(userId)

        nameET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i("MVVM", "Changed name value")

                mViewModel?.saveName(s?.toString() ?: "")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        ageET.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i("MVVM", "Changed age value:")

                val age = s?.toString()
                var ageI = 0;

                if (age != "") ageI = age?.toInt() ?: 0

                mViewModel?.saveAge(ageI)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater?.inflate(R.layout.fragment_edit_user_profile, container, false)
}
