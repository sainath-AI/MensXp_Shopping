package com.masai.sainath.mensxp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.ui.fragments.YouFragment
import kotlinx.android.synthetic.main.activity_edit_profile_acitivity.*

class EditProfileAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile_acitivity)


        val mFragmentManager = supportFragmentManager
        val mFragmentTransaction = mFragmentManager.beginTransaction()
        val mFragment = YouFragment()

        btnSave.setOnClickListener {

//            val mBundle = Bundle()
//            mBundle.putString("firstname",firstname.text.toString())
//            mBundle.putString("lastname",lastname.text.toString())
//            mBundle.putString("phoneNumber",phNumber.text.toString())
//            mFragment.arguments = mBundle
//            mFragmentTransaction.add(R.id.fragmentContainerView, mFragment).commit()

        }

    }
}